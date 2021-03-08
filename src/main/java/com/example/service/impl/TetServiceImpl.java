package com.example.service.impl;

import com.example.MyThread;
import com.example.mapper.TestMapper;
import com.example.service.TetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 郝少杰
 * @date 2021/2/10 11:57
 */
@Slf4j
@Service
public class TetServiceImpl implements TetService{

    @Resource
    TestMapper testDao;

    @Override
    public void getSql() {
        String a =testDao.getSql1();
        System.out.println(a);
    }


}
