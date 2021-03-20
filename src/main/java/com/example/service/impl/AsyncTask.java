package com.example.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author 郝少杰
 * @date 2021/3/10 14:22
 */
@Slf4j
@Service
public class AsyncTask {

    @Async
    public void async() throws InterruptedException {
        Thread.sleep(100000);
    }
}
