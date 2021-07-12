package com.example.annotation;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;

@Slf4j
public class MyTest {

    public static void main(String[] args) throws NoSuchFieldException {
        Class<MyPOJO> myPOJOClass = MyPOJO.class;
//        MyAnnotation myClassAnnotation = myPOJOClass.getAnnotation(MyAnnotation.class);
//        String name = myClassAnnotation.name();
//        System.out.println(name);

        // 获得字段注解
        Field name1 = myPOJOClass.getDeclaredField("name");// 暴力获取private修饰的成员变量
        MyAnnotation annotation = name1.getAnnotation(MyAnnotation.class);
//        System.out.println(annotation.name());
    }
}
