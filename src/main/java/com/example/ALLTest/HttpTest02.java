package com.example.ALLTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class HttpTest02 {
    public static void main(String[] args) {

        ExecutorService es = new ThreadPoolExecutor(100, 200, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());

        es.execute(new Runnable() {
            @Override
            public void run() {

            }
        });

    }
}
