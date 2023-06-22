package com.gusty.spring6.iocxml.life;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-life.xml");
        User user = context.getBean("user", User.class);
        System.out.println("6. bean對象創建完成了，可以使用了");
        System.out.println(user);
        //ApplicationContext裡有個方法會自動銷毀，不銷毀要用ClassPathXmlApplicationContext
        context.close();
    }
}
