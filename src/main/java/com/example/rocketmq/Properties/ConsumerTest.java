package com.example.rocketmq.Properties;

import com.aliyun.openservices.ons.api.*;

import java.util.Properties;

public class ConsumerTest {
    public static void main(String[] args) {
        Properties properties = new Properties();
        // 您在控制台创建的 Group ID
        properties.put(PropertyKeyConst.GROUP_ID, "test");
        // AccessKey 阿里云身份验证，在阿里云服务器管理控制台创建
        properties.put(PropertyKeyConst.AccessKey, "gPMxot1gyDTicLta");
        // SecretKey 阿里云身份验证，在阿里云服务器管理控制台创建
        properties.put(PropertyKeyConst.SecretKey, "q3EAD1X8CX01l8NfMIwcgZShtZ5hEB");
        // 设置 TCP 接入域名，进入控制台的实例管理页面的“获取接入点信息”区域查看
        properties.put(PropertyKeyConst.NAMESRV_ADDR,
                "10.242.10.63:9876,10.242.18.112:9876");
        // 集群订阅方式 (默认)
        properties.put(PropertyKeyConst.MessageModel, PropertyValueConst.CLUSTERING);
        // 广播订阅方式
        // properties.put(PropertyKeyConst.MessageModel, PropertyValueConst.BROADCASTING);

        Consumer consumer = ONSFactory.createConsumer(properties);
        consumer.subscribe("DEVDBH_UDBH_TOPIC_1", "Tag01", new MessageListener() {
            //订阅多个 Tag
            @Override
            public Action consume(Message message, ConsumeContext context) {
                System.out.println("Receive: " + message);
                return Action.CommitMessage;
            }
        });

//        //订阅另外一个 Topic，如需取消订阅该 Topic，请删除该部分的订阅代码，重新启动消费端即可
//        consumer.subscribe("TopicTestMQ-Other", "*", new MessageListener() {
//            //订阅全部 Tag
//            @Override
//            public Action consume(Message message, ConsumeContext context) {
//                System.out.println("Receive: " + message);
//                return Action.CommitMessage;
//            }
//        });

        consumer.start();
        System.out.println("Consumer Started");
    }
}
