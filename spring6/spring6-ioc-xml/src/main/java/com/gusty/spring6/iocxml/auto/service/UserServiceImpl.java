package com.gusty.spring6.iocxml.auto.service;

import com.gusty.spring6.iocxml.auto.dao.UserDao;

public class UserServiceImpl implements  UserService{

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUserService() {
        System.out.println("userService的方法執行了...");
        //調用dao的方法
        userDao.addUserDao();
    }
}
