package com.gusty.spring6.autowired.controller;

import com.gusty.spring6.autowired.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    //注入service

    //第1種方式，屬性注入
    //根據類型找到對應對象完成注入
//    @Autowired
//    private UserService userService;

    //第2種方式，set方法注入
//    private UserService userService;
//
//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }

    //第3種方式，構造方法注入
//    private UserService userService;
//
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

    //第4種方式，形參上注入
//    private UserService userService;
//
//    public UserController(@Autowired UserService userService) {
//        this.userService = userService;
//    }

    //第5種方式，只有一個無參數構造，可以不加註解
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void add() {
        System.out.println("執行controller...");
        userService.add();
    }
}
