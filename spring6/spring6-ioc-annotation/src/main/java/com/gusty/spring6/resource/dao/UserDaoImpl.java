package com.gusty.spring6.resource.dao;

import org.springframework.stereotype.Repository;

@Repository(value="myUserDao")
public class UserDaoImpl implements UserDao {


    @Override
    public void add() {
        System.out.println("執行dao....");
    }
}
