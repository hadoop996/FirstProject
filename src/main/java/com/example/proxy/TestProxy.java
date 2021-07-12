package com.example.proxy;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TestProxy {

    public static void main(String[] args) {
//        TestImpl test = new TestImpl();
//        System.out.println("start test");
//        Test proxyInstance = (Test) new ProxyTest(test).getProxyInstance();
//        proxyInstance.say();
//        System.out.println("end test");

        LocalDateTime now = LocalDateTime.now();
        long l = System.currentTimeMillis();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format2 = now.format(format);
        long l1 = System.currentTimeMillis();
        System.out.println(format2);
        System.out.println(l1-l);

        Date startDate = new Date();
        long l2 = System.currentTimeMillis();
        String format1 = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")).format(startDate);
        long l3 = System.currentTimeMillis();
        System.out.println(l3-l2);

        System.out.println(format1);
    }
}
