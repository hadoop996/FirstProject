package com.example.ALLTest;

import java.util.Random;

public class RandomTest {

    public static String getRandomNickname(int length) {
        String val = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            val += String.valueOf(random.nextInt(10));
        }
        return "0"+val;
    }

    public static void main(String[] args) {
        System.out.println("java生成随机数字10位数：" + getRandomNickname(10));
    }
}
