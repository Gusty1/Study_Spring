package com.gusty.spring6.autowired.service;

import com.gusty.spring6.autowired.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    //注入dao

    //第1種方式，屬性注入
    //根據類型找到對應對象完成注入
//    @Autowired
//    private UserDao userDao;

    //第2種方式，set方法注入
//    private UserDao userDao;
//
//    @Autowired
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    //第3種方式，構造方法注入
//    private UserDao userDao;
//
//    @Autowired
//    public UserServiceImpl(UserDao userDao) {
//        this.userDao = userDao;
//    }

    //第4種方式，形參上注入
//    private UserDao userDao;
//
//    public UserServiceImpl(@Autowired UserDao userDao) {
//        this.userDao = userDao;
//    }

    //最後一種方式，使用2個註解，根據名稱進行注入
    @Autowired
    @Qualifier(value = "userRedisDaoImpl")
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("執行service...");
        userDao.add();
    }
}
