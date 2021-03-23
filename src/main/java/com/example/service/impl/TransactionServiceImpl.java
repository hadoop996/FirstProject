package com.example.service.impl;

import com.example.mapper.TestMapper;
import com.example.service.TransactionService;
import com.ohaotian.plugin.base.exception.ZTBusinessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author 郝少杰
 * @date 2021/3/23 11:28
 */
@Service
public class TransactionServiceImpl implements TransactionService {
    @Resource
    UpdateServiceImpl updateService;

    @Override
    public void transactionTest() {
        System.out.println("进入方法");
        updateService.update();
        System.out.println("结束方法");
    }
}
