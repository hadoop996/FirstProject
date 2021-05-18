package com.example;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegertEST {


    volatile static int j = 1;

    public static void main(String[] args) {


        ExecutorService cachedThreadPool = new ThreadPoolExecutor(100, 200, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        for (int i=0;i<100;i++){
            cachedThreadPool.execute(() -> {

                test(j);
            });
        }
        cachedThreadPool.shutdown();
    }


    private static synchronized void test(int atomicInteger){
        System.out.println(j = j + 1);
    }
}
