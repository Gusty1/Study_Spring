package com.gusty.spring6.iocxml.auto.controller;

import com.gusty.spring6.iocxml.auto.service.UserService;

public class UserController {

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void addUser(){
        System.out.println("controller方法執行了...");
        //調用service的方法
        userService.addUserService();
    }
}
