package com.example.ALLTest;

import java.text.DecimalFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTEST {



    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger(1);
        ExecutorService cachedThreadPool = new ThreadPoolExecutor(100, 200, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        for (int i=0;i<3000;i++){
            cachedThreadPool.execute(() -> {
                test(atomicInteger);
                if (Integer.parseInt(atomicInteger.toString()) > 9999) {
                    atomicInteger.getAndSet(0);
                }
            });
            System.out.println(atomicInteger.get());
//            StringBuffer sb = new StringBuffer();
//            sb.append(new DecimalFormat("000000").format(atomicInteger));
//            System.out.println(sb);
        }
        cachedThreadPool.shutdown();
    }


    private static synchronized void test(AtomicInteger atomicInteger){
//        System.out.println(atomicInteger.getAndAdd(1));

        atomicInteger.getAndAdd(1);
    }
}
