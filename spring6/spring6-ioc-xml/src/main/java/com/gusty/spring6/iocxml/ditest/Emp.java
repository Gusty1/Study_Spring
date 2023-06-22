package com.gusty.spring6.iocxml.ditest;

import java.util.Arrays;

//員工類
public class Emp {

    //對象類型屬性，員工屬於某個部門
    private Dept dept;
    //員工名稱
    private String ename;
    //員工年齡
    private Integer age;
    //員工愛好
    private String[] loves;

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String[] getLoves() {
        return loves;
    }

    public void setLoves(String[] loves) {
        this.loves = loves;
    }

    public void work() {
        System.out.println(ename + " emp work... " + age);
        dept.info();
        System.out.println(Arrays.toString(loves));
    }
}
