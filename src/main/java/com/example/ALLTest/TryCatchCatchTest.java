package com.example.ALLTest;

public class TryCatchCatchTest {
    public static void main(String[] args) {

        try {
            int i = 1;
            int j = 0;
            int k = i / j;
        }catch (ArithmeticException ae){
            System.out.println(123);
        }catch (Exception e){
            System.out.println(456);
        }
    }
}
