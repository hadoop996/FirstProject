package com.example.config;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

/**
 * @author 郝少杰
 * @date 2021/3/10 16:26
 */
@Component
public class UserBroadcastThread implements Runnable {

    private int threadCnt = 10;

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            int i = 1;
            System.out.println(i++);
            Thread.sleep(1000);
        }
    }
}
