package com.gusty;

import com.gusty.bean.AnnotationApplicationContext;
import com.gusty.bean.ApplicationContext;
import com.gusty.service.UserService;

public class TestUser {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationApplicationContext("com.gusty");
        UserService userService = (UserService)context.getBean(UserService.class);
        System.out.println(userService);
        userService.add();
    }
}
