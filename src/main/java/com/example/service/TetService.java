package com.example.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author 郝少杰
 * @date 2021/2/10 11:56
 */
@Service
public interface TetService {
    void getSql() throws Exception;

    @Async
    void asyn1() throws InterruptedException;

}
