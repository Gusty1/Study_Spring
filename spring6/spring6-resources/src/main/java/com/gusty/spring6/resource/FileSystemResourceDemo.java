package com.gusty.spring6.resource;

import org.springframework.core.io.FileSystemResource;

import java.io.IOException;
import java.io.InputStream;

//訪問系統資源
public class FileSystemResourceDemo {

    public static void main(String[] args) {
        //相對 & 絕對 路徑都可以
        //loadFileResource("D:\\gusty.txt");

        loadFileResource("gusty.txt");
    }

    public static void loadFileResource(String path) {

        //創建對象
        FileSystemResource resource = new FileSystemResource(path);

        System.out.println(resource.getFilename());
        System.out.println(resource.getDescription());

        try {
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
