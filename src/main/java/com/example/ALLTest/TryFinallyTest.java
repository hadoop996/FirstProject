package com.example.ALLTest;

public class TryFinallyTest {

    public static void main(String[] args) {
        int i = 0;
        int j = 1;
        int k = j/i;
        try {
            System.out.println("123");
        }catch (Exception e){
            System.out.println("456");
        }finally {
            System.out.println("789");
        }
    }
}
