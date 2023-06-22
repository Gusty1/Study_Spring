package com.gusty.spring6.aop.example;

public class TestCal {
    public static void main(String[] args) {

        //創建代理對象(動態)
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator) proxyFactory.getProxy();
        proxy.add(1, 2);
    }
}
