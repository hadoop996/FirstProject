package com.example;

import com.example.config.UserBroadcastThread;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@MapperScan("com.example.mapper")
@EnableAsync(proxyTargetClass=true)
@EnableTransactionManagement
public class DemoApplication {

    @Autowired
    private UserBroadcastThread userBroadcastThread;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

//    @Bean
//    public void readUserBroadcast(){
//        new Thread(userBroadcastThread).start();
//    }
}
