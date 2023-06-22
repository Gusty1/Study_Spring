package com.gusty.spring6.resource;

import com.gusty.spring6.config.SpringConfig;
import com.gusty.spring6.resource.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserAnno {
    public static void main(String[] args) {
        //加載配置類(配置類的class)
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserController controller = context.getBean(UserController.class);
        controller.add();
    }
}
