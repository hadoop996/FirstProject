package com.example.rocketmq.common;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

public class Provider {
    public static void main(String[] args) throws Exception {
        DefaultMQProducer defaultMQProducer = new DefaultMQProducer("test");
        defaultMQProducer.setNamesrvAddr("127.0.0.1:9876");
        defaultMQProducer.start();
        for(int i = 0;i<100;i++){
            try {
                Message message = new Message("hsj","Tag1",
                        ("Hello World"+i).getBytes("UTF-8"));
                SendResult sendResult = defaultMQProducer.send(message);
                System.out.println("发送消息"+sendResult.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        defaultMQProducer.shutdown();
    }
}
