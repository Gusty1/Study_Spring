package com.gusty.spring6.resource;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

//訪問類路徑下資源
public class ClassPathResourceDemo {

    public static void main(String[] args) {
        loadResource("gusty.txt");
    }

    public static void loadResource(String path) {
        //創建對象ClassPathResource
        ClassPathResource resource = new ClassPathResource(path);

        System.out.println(resource.getFilename());
        System.out.println(resource.getDescription());

        try {
            //獲取文件內容
            InputStream in = resource.getInputStream();
            byte[] b = new byte[1024];
            while (in.read(b) != -1) {
                System.out.println(new String(b));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
