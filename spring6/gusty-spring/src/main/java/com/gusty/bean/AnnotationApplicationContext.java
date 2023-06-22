package com.gusty.bean;

import com.gusty.anno.Bean;
import com.gusty.anno.Di;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AnnotationApplicationContext implements ApplicationContext {

    //創建map集合，放bean對象
    private static Map<Class, Object> beanFactory = new HashMap<>();
    private static String rootPath;

    //返回對象
    @Override
    public Object getBean(Class clazz) {
        return beanFactory.get(clazz);
    }

    //設置包掃描規則
    //當前包和其子包，哪個類有@Bean，把這個類通過反射實例化
    public AnnotationApplicationContext(String basePackage) {
        //com.gusty
        //1. 把.換成\
        String packagePath = basePackage.replaceAll("\\.", "\\\\");

        //2. 獲取包的絕對路徑
        try {
            Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(packagePath);
            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();
                String filePath = URLDecoder.decode(url.getFile(), "utf-8");
                //System.out.println(filePath);
                //獲取包前面的通用路徑，作字符串截取
                rootPath = filePath.substring(0, filePath.length() - packagePath.length());

                //包掃描
                loadBean(new File(filePath));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //屬性注入
        loadDi();
    }

    //包掃描過程，實例化
    private void loadBean(File file) throws Exception {
        //1.判斷當前是否為文件夾
        if (file.isDirectory()) {
            //2.獲取文件夾裡的所有內容
            File[] childrenFiles = file.listFiles();

            //3.判斷文件夾裡是否為空，是的話直接返回
            if (childrenFiles == null || childrenFiles.length == 0) {
                return;
            }

            //4.若3不為空，遍歷文件夾裡所有內容
            for (File child : childrenFiles) {
                //4-1.遍歷得到每個File對象，繼續判斷，如果還是文件夾
                if (child.isDirectory()) {
                    //遞迴
                    loadBean(child);
                } else {
                    //4-2.遍歷得到的File對象不是文件夾，是文件
                    //4-3.得到包路徑+類名稱部分-字符串截取
                    String pathWithClass = child.getAbsolutePath().substring(rootPath.length() - 1);

                    //4-4.判斷當前文件類型是否為.class
                    if (pathWithClass.contains(".class")) {
                        //4-5.如果是.class類型，把路徑\替換成. 把.class去掉
                        //最終應得的結果:com.gusty.service.UserServiceImpl
                        String allName = pathWithClass.replaceAll("\\\\", ".").replace(".class", "");

                        //4-6.判斷類上面是否有@Bean，有的話實例化過程
                        //4-6-1.獲取類的class
                        Class<?> clazz = Class.forName(allName);

                        //4-6-2.判斷是不是接口
                        if (!clazz.isInterface()) {
                            //4-6-3.判斷上面是否有註解@Bean
                            Bean annotation = clazz.getAnnotation(Bean.class);
                            if (annotation != null) {
                                //4-6-4.實例化
                                Object instance = clazz.getConstructor().newInstance();

                                //4-7.把對象實例化後，放到map集合beanFactory
                                //4-7-1.判斷當前類如果有接口，讓接口class作為map的key
                                if (clazz.getInterfaces().length > 0) {
                                    beanFactory.put(clazz.getInterfaces()[0], instance);
                                } else {
                                    beanFactory.put(clazz, instance);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    //屬性注入
    private void loadDi() {
        //實例化對象在beanFactory的map集合裡面
        //1.遍歷beanFactory的map集合
        Set<Map.Entry<Class, Object>> entries = beanFactory.entrySet();
        for (Map.Entry<Class, Object> entry : entries) {
            //2.獲取map集合每個對象(value)，每個對象屬性或取到
            Object obj = entry.getValue();

            //獲取對象class
            Class<?> clazz = obj.getClass();

            //獲取每個對象中的屬性
            Field[] declaredFields = clazz.getDeclaredFields();

            //3.遍歷得到每個對象屬性數組，得到每個屬性
            for (Field field : declaredFields) {
                //4.判斷屬性上面是否有@Di註解
                Di annotation = field.getAnnotation(Di.class);
                if (annotation != null) {
                    //如果是私有屬性(private)，要設置允許訪問
                    field.setAccessible(true);

                    //5.如果有@Di註解，把對象進行設置(注入)
                    try {
                        field.set(obj, beanFactory.get(field.getType()));
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
