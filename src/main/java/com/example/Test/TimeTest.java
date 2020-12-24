package com.example.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 郝少杰
 * @date 2020/11/18 15:59
 */
public class TimeTest {
    public static void main(String[] args) {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
    }
}
