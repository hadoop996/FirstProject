package com.example.work;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author 郝少杰
 * @date 2021/3/18 19:02
 */
public class TestDemo {

    public static void main(String[] args) {
        DecimalFormat df1 = new DecimalFormat("0");//格式化小数，不足的补0
        String random = df1.format(Math.random() * 1000000);
//        UUID uuid = UUID.randomUUID();
        String uuid = "UD0";
        String yyyyMMddHHmmssSSS = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS").format(LocalDateTime.now());
        String num = yyyyMMddHHmmssSSS+uuid+random;
        System.out.println(num);
    }
}
