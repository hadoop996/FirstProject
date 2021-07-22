package com.example.ALLTest;

import java.util.UUID;

/**
 * @author 郝少杰
 * @date 2021/3/11 17:11
 */
public class UUIDTest {

    public static void main(String[] args) {
        String tranId = UUID.randomUUID().toString().replaceAll("-", "");
        System.out.println(tranId);
    }

}
