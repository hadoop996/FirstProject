package com.example.rocketmq.Properties;

import com.example.rocketmq.RocketMQUtil;

public class CreateTopic {
    public static void main(String[] args) {
        RocketMQUtil.createTopic("10.242.10.63:9876","DEVHSJ_UDBH_TOPIC_5");
    }
}
