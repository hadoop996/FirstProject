package com.example.ALLTest;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.time.LocalDate;

public class TimerTest {
    public static void main(String[] args) {

        long l = System.currentTimeMillis();
        DateTime date = DateUtil.date();
        long l1 = System.currentTimeMillis();
        LocalDate now = LocalDate.now();
        long l2 = System.currentTimeMillis();
        System.out.println(l1-l);
        System.out.println(l2-l1);
    }
}
