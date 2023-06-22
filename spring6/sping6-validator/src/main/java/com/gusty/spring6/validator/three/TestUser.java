package com.gusty.spring6.validator.three;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestUser {
    public static void main(String[] args) {
        ApplicationContext context =new AnnotationConfigApplicationContext(ValidationConfig.class);
        MyService service = context.getBean(MyService.class);
        User user =new User();
        user.setName("Gusty");
        user.setPhone("13566754321");
        user.setMessage("test a gusty");
        service.testMethod(user);
    }
}
