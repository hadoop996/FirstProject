package com.example.ALLTest;

/**
 * @author 郝少杰
 * @date 2021/2/3 17:33
 */
public class ErrorExceptionTest {
    public static void main(String[] args) {
        String a = getA();
        System.out.println("123123"+a);

    }

    public static  String getA(){

        try {
            throw new Exception();
        }catch (Exception e){
            System.out.println("123");
            e.printStackTrace();
        }
        return null;
    }
}
