package com.example.service.impl;

import com.example.service.TetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 郝少杰
 * @date 2021/3/18 0:38
 */
@Slf4j
@Service
public class TestServiceImpl implements ApplicationRunner {

    @Resource
    private TetService tetService;
    @Resource
    private TransactionServiceImpl transactionService;
    @Override
    public void run(ApplicationArguments args) throws Exception {
//        tetService.getSql();
        transactionService.transactionTest();
    }
}
