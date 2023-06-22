package com.gusty.spring6.junit.junit5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

//測試方法1
@SpringJUnitConfig(locations = "classpath:bean.xml")

//測試方法2
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration("classpath:bean.xml")
public class SpringTestJunit5 {

    @Autowired
    private User user;

    //測試方法
    @Test
    public void testUser(){
        System.out.println(user);
        user.run();
    }

}
