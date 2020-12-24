//package com.example.config;
//
//import org.apache.curator.framework.CuratorFramework;
//import org.apache.curator.framework.CuratorFrameworkFactory;
//import org.apache.curator.retry.RetryNTimes;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.annotation.Resource;
//
///**
// * @ClassName: ZookeeperConfig
// * @Description: zk客户端初始化
// * @Date: 2019/3/28 10:45
// * @Author fuchangmin
// */
//@Configuration
//public class ZookeeperConfig {
//
//    @Resource
//    private RegistryCenterProperties registryCenterProperties;
//
//    @Bean
//    public CuratorFramework curatorFramework() {
//        // these are reasonable arguments for the ExponentialBackoffRetry. The first
//        // retry will wait 1 second - the second will wait up to 2 seconds - the
//        // third will wait up to 4 seconds.
//        //ExponentialBackoffRetry retryPolicy = new ExponentialBackoffRetry(1000, 3);
//
//        RetryNTimes retryPolicy = new RetryNTimes(5, 1000);
//
//        // The simplest way to get a CuratorFramework instance. This will use default v
//        // alues.
//        // The only required arguments are the connection string and the retry policy
//        CuratorFramework client = CuratorFrameworkFactory.builder()
//                .connectString(registryCenterProperties.getZkAddressList())
//                .retryPolicy(retryPolicy)
//                .connectionTimeoutMs(5000)
//                .sessionTimeoutMs(40000)
//                // etc. etc.
//                .build();
//        client.start();
//        client.create();
//        return client;
//    }
//
//}
