package com.example.ALLTest;

/**
 * @author 郝少杰
 * @date 2020/12/9 15:46
 */
public class ExceptionTest {

    public static void main(String[] args) {
        try {
            getTry();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("m---"+e.getMessage());
            System.out.println("e---"+e);
        }
        System.out.println("go on");
    }

    public static void getTry() throws Exception{
        String a = null;
        a.toString();
        System.out.println("内");
    }

}
