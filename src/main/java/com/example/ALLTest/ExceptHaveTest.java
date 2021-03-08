package com.example.ALLTest;

/**
 * @author 郝少杰
 * @date 2021/1/29 16:04
 */
public class ExceptHaveTest {
    public static void main(String[] args) {
        try {
            throw new Exception();
        }catch (Exception e){
            System.out.println("123");
        }
    }
}
