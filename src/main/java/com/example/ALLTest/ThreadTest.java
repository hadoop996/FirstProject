package com.example.ALLTest;

/**
 * @author 郝少杰
 * @date 2020/12/11 17:24
 */
public class ThreadTest {
    public static void main(String[] args) {
        String a = null;
        for (int i= 0 ;i<10;i++){
            try{
                System.out.println(a);
//                a.toString();
            }catch(Exception e) {
                e.printStackTrace();
                break;
            }
        }

        System.out.println(123);
    }
}
