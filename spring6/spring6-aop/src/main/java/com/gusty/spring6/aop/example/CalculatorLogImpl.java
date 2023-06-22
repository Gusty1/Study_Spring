package com.gusty.spring6.aop.example;

//帶日誌的實現類
public class CalculatorLogImpl implements Calculator {
    @Override
    public int add(int i, int j) {
        System.out.println("[日誌] add方法開始了，參數是： " + i + "," + j);
        int result = i + j;
        System.out.println("方法內部result = " + result);
        System.out.println("[日誌] add方法結束了，結果是： " + result);
        return result;
    }

    @Override
    public int sub(int i, int j) {
        System.out.println("[日誌] sub方法開始了，參數是： " + i + "," + j);
        int result = i - j;
        System.out.println("方法內部result = " + result);
        System.out.println("[日誌] sub方法結束了，結果是： " + result);
        return result;
    }

    @Override
    public int mul(int i, int j) {
        System.out.println("[日誌] mul方法開始了，參數是： " + i + "," + j);
        int result = i * j;
        System.out.println("方法內部result = " + result);
        System.out.println("[日誌] mul方法結束了，結果是： " + result);
        return result;
    }

    @Override
    public int div(int i, int j) {
        System.out.println("[日誌] div方法開始了，參數是： " + i + "," + j);
        int result = i / j;
        System.out.println("方法內部result = " + result);
        System.out.println("[日誌] div方法結束了，結果是： " + result);
        return result;
    }
}
