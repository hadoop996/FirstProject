package com.example.ALLTest;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 郝少杰
 * @date 2021/4/7 19:16
 */
public class TimeTempTest {
    public static void main(String[] args) {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmm");//设置日期格式
        System.currentTimeMillis();
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
    }
}
