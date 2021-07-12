package com.example.ALLTest;

import java.util.concurrent.*;

public class OneThreadTest {
    public static void main(String[] args) {
        ExecutorService ex= new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        ex.submit(new Runnable() {
            @Override
            public void run() {
                for(int j=0;j<10;j++) {
                    System.out.println(Thread.currentThread().getName()+j);
                }

            }
        });
        ex.shutdown();
        System.out.println("123");
    }
}
