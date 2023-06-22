package com.gusty.spring6.aop.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyFactory {

    //目標對象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    //返回代理對象
    public Object getProxy() {
        /*
         * Proxy.newProxyInstance()方法
         * 有3個參數
         *1.ClassLoader: 加載動態生成代理類的加載器
         *2.Class[] interFaces: 目標對象實現的所有接口的class類型數組
         *3.InvocationHandler: 設置代理對象實現目標對象方法的過程
        */

        //1.ClassLoader: 加載動態生成代理類的加載器
        ClassLoader classLoader = target.getClass().getClassLoader();

        //2.Class[] interFaces: 目標對象實現的所有接口的class類型數組
        Class<?>[] interfaces = target.getClass().getInterfaces();

        //3.InvocationHandler: 設置代理對象實現目標對象方法的過程
        InvocationHandler invocationHandler = new InvocationHandler() {

            //第一個參數: 代理對象
            //第二個參數: 需要重寫目標對象的方法
            //第三個參數: method方法裡面的參數
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                //方法調用之前輸出
                System.out.println("[動態代理][日誌] " + method.getName() + " ，參數： " + Arrays.toString(args));

                //調用目標的方法
                Object result = method.invoke(target, args);

                //方法調用之後輸出
                System.out.println("[動態代理][日誌] " + method.getName() + " ，結果： " + result);

                return result;
            }
        };

        return Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
    }
}
