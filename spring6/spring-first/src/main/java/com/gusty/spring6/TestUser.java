package com.gusty.spring6;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationTargetException;

public class TestUser {

    //創建logger對象
    private Logger logger = LoggerFactory.getLogger(TestUser.class);

    @Test
    public void testUserObject() {
        //1.加載spring配置文件，對象創建。()裡面放resources的名稱.xml
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        //2.獲取創建的對象。()裡面放bean的id
        User user = (User) context.getBean("user");
        System.out.println("1." + user);
        //3.使用對象調用方法進行測試
        user.add();

        logger.info("log調用成功了");
    }

    //反射創建對象
    @Test
    public void testUserObject1() throws Exception{
        //獲取class對象
        Class clazz = Class.forName("com.gusty.spring6.User");
        //調用方法創建對象
        //Object 0 = clazz.newInstance();
        User user = (User)clazz.getDeclaredConstructor().newInstance();
        System.out.println(user);
    }
}
