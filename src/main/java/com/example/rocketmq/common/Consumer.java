package com.example.rocketmq.common;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

public class Consumer {
    public static void main(String[] args) {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("test");
        consumer.setNamesrvAddr("127.0.0.1:9876");
        try {
            consumer.subscribe("hsj","*");
            consumer.registerMessageListener(new MessageListenerConcurrently() {
                @Override
                public ConsumeConcurrentlyStatus
                consumeMessage(List<MessageExt> list,
                               ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                    for(MessageExt messageExt :list){
                        String str  =  new String(messageExt.getBody());
                        System.out.println("接收消息"+str);
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return  ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
            });
            consumer.start();
            System.out.println("消费者已启动");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
