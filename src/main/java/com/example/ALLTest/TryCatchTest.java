package com.example.ALLTest;

public class TryCatchTest {
    public static void main(String[] args) {
        try {
            fun1();
        }catch (Exception e){
            System.out.println("nei");
            e.printStackTrace();
        }
        System.out.println("内");
    }

    private static void fun1() {
        try {
            int i = 1/0;
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("外");
    }


}
