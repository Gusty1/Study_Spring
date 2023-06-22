package com.gusty.spring6.validator.one;


import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

//校驗測試
public class TestPerson {
    public static void main(String[] args) {
        //創建person對象
        Person person = new Person();
        person.setName("Gusty");
        person.setAge(350);

        //創建person對應databinder
        DataBinder binder = new DataBinder(person);

        //設置校驗器
        binder.setValidator(new PersonValidator());

        //調用方法執行校驗
        binder.validate();

        //輸出校驗結果
        BindingResult result = binder.getBindingResult();
        System.out.println(result.getAllErrors());

    }
}
