package com.example.utils;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.management.monitor.Monitor;

/**
 * @author 郝少杰
 * @date 2021/2/10 23:03
 */
@Slf4j
@Component("mTask")
@Scope("prototype")
public class MoniotrTask extends Thread {

    //参数封装
    private Monitor monitor;

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }


    @Override
    public void run() {
        log.info("线程:"+Thread.currentThread().getName()+"运行中.....");
    }

}