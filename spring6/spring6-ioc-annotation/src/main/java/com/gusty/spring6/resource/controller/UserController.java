package com.gusty.spring6.resource.controller;

import com.gusty.spring6.resource.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;

@Controller(value="myUserController")
public class UserController {

    //注入service

    //根據名稱進行注入
//    @Resource(name = "myUserService")
//    private UserService userService;

    //根據類型配置
    @Resource
    private UserService userService;


    public void add() {
        System.out.println("執行controller...");
        userService.add();
    }
}
