package com.gusty.spring6.validator.one;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PersonValidator implements Validator {

    //要在哪個方法上進行驗證
    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }


    //驗證邏輯
    @Override
    public void validate(Object target, Errors errors) {

        //name不能為空
        ValidationUtils.rejectIfEmpty(errors,"name","name.empty","name is null");

        //age不能小於0，不能大於200
        Person p = (Person) target;
        if(p.getAge()<0){
            errors.rejectValue("age","age.value.error","age < 0");
        }else if(p.getAge()>200){
            errors.rejectValue("age","age.value.error.old","age > 200");
        }

    }
}
