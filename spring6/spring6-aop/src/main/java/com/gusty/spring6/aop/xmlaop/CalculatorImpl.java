package com.gusty.spring6.aop.xmlaop;

import org.springframework.stereotype.Component;

//基本實現類
@Component
public class CalculatorImpl implements Calculator {
    @Override
    public int add(int i, int j) {
        int result = i + j;
        System.out.println("方法內部result = " + result);
        //為了測試，模擬異常出現
        //int a = 1 / 0;
        return result;
    }

    @Override
    public int sub(int i, int j) {
        int result = i - j;
        System.out.println("方法內部result = " + result);
        return result;
    }

    @Override
    public int mul(int i, int j) {
        int result = i * j;
        System.out.println("方法內部result = " + result);
        return result;
    }

    @Override
    public int div(int i, int j) {
        int result = i / j;
        System.out.println("方法內部result = " + result);
        return result;
    }
}
