package com.gusty.spring6.iocxml.ditest;

import java.util.List;

//部門類
public class Dept {
    //一個部門有很多員工
    private List<Emp> empList;
    //部門名稱
    private String dname;

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public List<Emp> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Emp> empList) {
        this.empList = empList;
    }

    public void info() {
        System.out.println("部門名稱: " + dname);
        for (Emp emp : empList) {
            System.out.println(emp.getEname());
        }
    }
}
