package com.example.ALLTest;

import org.junit.Test;
import org.springframework.scheduling.annotation.Async;

/**
 * @author 郝少杰
 * @date 2021/3/10 11:42
 */
public class AsyncTest {

    @Test
    public void test() throws InterruptedException {
        System.out.println("---------进入");
        async();
        System.out.println("---------出去");
    }

    @Async
    public void async() throws InterruptedException {
        Thread.sleep(100000);
    }
}
