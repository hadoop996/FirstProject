package com.example.ALLTest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author 郝少杰
 * @date 2021/4/2 14:56
 */
@Slf4j
public class DataTest {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        for (int i = 0;i<100;i++){
            atomicInteger.getAndAdd(1);
            addMath(atomicInteger);
        }
        log.error("计数器{}",atomicInteger);
    }

    private static void addMath(AtomicInteger atomicInteger) {
        StringBuffer sb = new StringBuffer();
        if (Integer.parseInt(atomicInteger.toString()) > 78) {
            atomicInteger.getAndSet(0);
        }
        sb.append(new DecimalFormat("000000").format(atomicInteger));
        System.out.println(sb);
    }


}
