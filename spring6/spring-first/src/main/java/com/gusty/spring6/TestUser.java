package com.gusty.spring6;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {
    @Test
    public void testUserObject() {
        //1.加載spring配置文件，對象創建。()裡面放resources的名稱.xml
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        //2.獲取創建的對象。()裡面放bean的id
        User user = (User) context.getBean("user");
        System.out.println("1." + user);
        //3.使用對象調用方法進行測試
        user.add();
    }
}
