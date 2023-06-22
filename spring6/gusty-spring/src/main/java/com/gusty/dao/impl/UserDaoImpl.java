package com.gusty.dao.impl;

import com.gusty.anno.Bean;
import com.gusty.dao.UserDao;

@Bean
public class UserDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("dao...");
    }
}
