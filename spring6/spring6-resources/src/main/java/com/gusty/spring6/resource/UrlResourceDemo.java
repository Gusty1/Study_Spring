package com.gusty.spring6.resource;

import org.springframework.core.io.UrlResource;

import java.net.MalformedURLException;

//演示UrlResource訪問網路資源
public class UrlResourceDemo {

    public static void main(String[] args) {
        //http前綴開頭的
        //loadUrlResource("https://fgo.wiki/w/%E9%A6%96%E9%A1%B5");

        //file前綴
        loadUrlResource("file:gusty.txt");

    }

    //訪問前綴是http、file
    public static  void loadUrlResource(String path){

        try {
            //創建Resource實現類的對象UrlResource
            UrlResource url = new UrlResource(path);

            //獲取資源信息
            System.out.println(url.getFilename());
            System.out.println(url.getURI());
            System.out.println(url.getDescription());
            System.out.println(url.getInputStream().read());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
