package com.gusty.service.impl;

import com.gusty.anno.Bean;
import com.gusty.anno.Di;
import com.gusty.dao.UserDao;
import com.gusty.service.UserService;

@Bean
public class UserServiceImpl implements UserService {
    @Di
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("service...");
        //調用dao的方法
        userDao.add();
    }
}
