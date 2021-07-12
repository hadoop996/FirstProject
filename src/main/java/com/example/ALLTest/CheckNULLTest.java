package com.example.ALLTest;

import cn.hutool.core.util.StrUtil;
import com.example.utils.SystemClock;
import org.apache.commons.lang3.StringUtils;

import java.sql.SQLOutput;
import java.util.Locale;

public class CheckNULLTest {
    public static void main(String[] args) {
//        String b = "Null";
//        long l1 = SystemClock.currentTimeMillis();
//        System.out.println(b.toUpperCase(Locale.ROOT).equals("NULL"));
//        System.out.println(b.toUpperCase(Locale.ROOT).equals("NULL"));
//        System.out.println(b.toUpperCase(Locale.ROOT).equals("NULL"));
//        System.out.println(b.toUpperCase(Locale.ROOT).equals("NULL"));
//        System.out.println(b.toUpperCase(Locale.ROOT).equals("NULL"));
//        long l2 = SystemClock.currentTimeMillis();
//        long l3 = SystemClock.currentTimeMillis();
//        System.out.println(b.equalsIgnoreCase("NULL"));
//        System.out.println(b.equalsIgnoreCase("NULL"));
//        System.out.println(b.equalsIgnoreCase("NULL"));
//        System.out.println(b.equalsIgnoreCase("NULL"));
//        System.out.println(b.equalsIgnoreCase("NULL"));
//        long l4 = SystemClock.currentTimeMillis();
//        System.out.println((l2 - l1) + "----" + (l4 - l3));
//
//        System.out.println(StringUtils.isBlank(b));
        
        String a = "0100";
        int i = Integer.parseInt(a);
        System.out.println(i);
    }
}
