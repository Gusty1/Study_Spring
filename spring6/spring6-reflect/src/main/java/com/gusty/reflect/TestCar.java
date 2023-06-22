package com.gusty.reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestCar {

    //1. 獲取class對象的多種方式
    @Test
    public void test01() throws Exception {
        //一. 類名.class獲取
        Class clazz1 = Car.class;

        //二. 對象.getClass()
        Class clazz2 = new Car().getClass();

        //三. Class.forName("全路徑")
        Class clazz3 = Class.forName("com.gusty.reflect.Car");


        //實例化
        Car car = (Car) clazz3.getDeclaredConstructor().newInstance();
        System.out.println(car);

    }

    //2. 獲取構造方式
    @Test
    public void test02() throws Exception {
        Class clazz = Car.class;
        //獲取所有構造
        //getConstructors()可以獲取所有public的構造方法
        //getDeclaredConstructor()可以獲取所有的構造方法public、private...
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor c : constructors) {
            //結果會顯示2個方法，一個是有參構造，另一個是無參構造
            //所以有參有3個參數，無參有0個參數
            System.out.println("方法名稱: " + c.getName() + " 參數個數: " + c.getParameterCount());
        }

        //指定有參數構造創建對象
        //一. 構造public
//        Constructor c1 = clazz.getConstructor(String.class, int.class, String.class);
//        Car car1 = (Car)c1.newInstance("BENZ", 4, "藍色");
//        System.out.println(car1);

        //二. 構造private
        Constructor c2 = clazz.getDeclaredConstructor(String.class, int.class, String.class);
        c2.setAccessible(true);//允許私有的訪問
        Car car2 = (Car) c2.newInstance("TOYOTA", 9, "白色");
        System.out.println(car2);
    }

    //3. 獲取屬性
    @Test
    public void test03() throws Exception {
        Class clazz = Car.class;
        Car car = (Car) clazz.getDeclaredConstructor().newInstance();
        //獲取所有public屬性
        //Field[] fields = clazz.getFields();
        //獲取所有屬性(public、private...)
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            //向屬性注入值
            if (field.getName().equals("name")) {
                //設置允許訪問
                field.setAccessible(true);
                field.set(car, "TOYOTA");
            }
            System.out.println(field.getName());
            System.out.println(car);
        }
    }

    //4.獲取方法
    @Test
    public void test04() throws Exception {
        //實例化對象
        Car car = new Car("三菱", 3, "綠色");
        Class clazz = car.getClass();
        //一. public方法
        Method[] methods = clazz.getMethods();
        for (Method m1 : methods) {
            //System.out.println(m1.getName());
            //執行方法，以toString為例
            if (m1.getName().equals("toString")) {
                String invoke = (String) m1.invoke(car);
                System.out.println("toString執行了: " + invoke);
            }
        }

        //一. private方法
        Method[] methodsAll = clazz.getDeclaredMethods();
        for (Method m : methodsAll) {
            //執行方法 run
            if(m.getName().equals("run")){
                //私有方法需要先設置允許訪問
                m.setAccessible(true);
                m.invoke(car);
            }
        }
    }
}
