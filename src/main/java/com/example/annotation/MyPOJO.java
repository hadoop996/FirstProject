package com.example.annotation;

public class MyPOJO {

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "MyPOJO{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public MyPOJO(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public MyPOJO() {
    }
}
