package com.example.service;


import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author 郝少杰
 * @date 2021/2/19 10:02
 */
public interface AsyncService {

    /**
     *  执行异步任务
     */
    void mainWait(CountDownLatch countDownLatch, int num, int size, List<Integer> list);
}
