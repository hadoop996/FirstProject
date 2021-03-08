package com.example.error;

import com.example.domain.Dog;

/**
 * @author 郝少杰
 * @date 2021/1/25 11:01
 */
public class ErrorTest {
    public static void main(String[] args) throws Exception {
        for (int i = 0;i<5;i++){
            Dog err = err(i);
            if (err!=null){
                System.out.println("123");
            }else {
                System.out.println("321");
            }
        }
    }

    public static Dog err(int i) throws Exception {
        if (i<2){
            throw new Exception();
        }else {
            return null;
        }
    }
}
