package com.example.ALLTest;

/**
 * @author 郝少杰
 * @date 2021/3/23 12:18
 */
public class SubStringTest {
    public static void main(String[] args) {
        String userId = "010-1231231231231";
        String str=userId.substring(0, userId.indexOf("-"));
        userId = userId.substring(str.length()+1,userId.length());
        System.out.println(userId);
    }
}
