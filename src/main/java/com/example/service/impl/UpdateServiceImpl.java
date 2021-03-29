package com.example.service.impl;

import com.example.mapper.TestMapper;
import com.example.service.UpdateService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author 郝少杰
 * @date 2021/3/23 13:03
 */
@Service
public class UpdateServiceImpl implements UpdateService {
    @Resource
    TestMapper testDao;

    @Transactional
    @Override
    public void update(){
        System.out.println("进入事务");
        testDao.insertDemo();
        System.out.println("报错隔离");
        throw new RuntimeException("123");
    }
}
