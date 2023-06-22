package com.gusty.spring6.iocxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUSer {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        //根據id獲取bean
        User user1 = (User) context.getBean("user");
        System.out.println("1.根據id獲取bean: " + user1);
        
        //根據class獲取bean。**若class不唯一會報錯
        User user2 = context.getBean(User.class);
        System.out.println("2.根據class獲取bean: " + user2);
        
        //根據id和class獲取bean
        User user3 = context.getBean("user", User.class);
        System.out.println("3.根據id和class獲取bean: " + user3);
    }
}
