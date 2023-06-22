package com.gusty.spring6.tx.service;

public interface CheckoutService {

    //買多本書的法
    void checkout(Integer[] bookIds, Integer userId);
}
