package com.example.service.impl;

import com.example.domain.PersonPo;
import com.example.mapper.TestMapper;
import com.example.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.Executors.*;

/**
 * @author 郝少杰
 * @date 2021/2/19 10:03
 */
@Service
@Slf4j
public class AsyncServiceImpl implements AsyncService {

    @Resource
    TestMapper testDao;

    @Override
    @Async("asyncServiceExecutor")
    public void mainWait(CountDownLatch countDownLatch,int num,int size,List<Integer> list) {
        try {
            System.out.println("线程" + Thread.currentThread().getId() + "开始执行");
            String name = "线程" + Thread.currentThread().getId();
            List<Integer> newList =  list.subList(num, num+size);
            List<PersonPo> personPos = new Vector<>();
            long l = System.currentTimeMillis();
            int j = 1;
            ExecutorService cachedThreadPool = Executors.newFixedThreadPool(50);
            for (int i :newList){
                cachedThreadPool.execute(new Runnable() {
                    @Override
                    public void run() {
                        getOne();
                        PersonPo personPo = new PersonPo(name,i);
                        personPos.add(personPo);
                    }
                });
            }
            cachedThreadPool.shutdown();
            while (!cachedThreadPool.awaitTermination(1, TimeUnit.SECONDS)){
                System.out.println("线程池未关闭");
            }
            testDao.insertSql(personPos);
            long l1 = System.currentTimeMillis();
            long l2 = l1 - l;
            System.out.println("线程" + Thread.currentThread().getId() +"耗时"+l2);
            System.out.println("线程" + Thread.currentThread().getId() + "执行结束");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            countDownLatch.countDown();
        }
    }

    public void getOne(){
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }
}
