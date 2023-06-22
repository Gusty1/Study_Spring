package com.gusty.spring6.iocxml.life;

public class User {

    private String name;

    //無參數構造
    public User(){
        System.out.println("1. bean對象創建，調用無參數構造");
    }

    //初始化方法
    public void initMethod(){
        System.out.println("4. 對象初始化，調用指定的初始化方法");
    }

    //銷毀的方法
    public void destroyMethod(){
        System.out.println("7. bean對象銷毀，調用指定的銷毀方法");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("2. 給bean對象設置屬性值");
        this.name = name;
    }
}
