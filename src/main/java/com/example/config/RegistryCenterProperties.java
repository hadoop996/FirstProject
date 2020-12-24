package com.example.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @ClassName: RegistryCenterProperties
 * @Description: zk配置信息
 * @Date: 2019/3/28 10:45
 * @Author fuchangmin
 */
@Data
@Configuration
@Component
@ConfigurationProperties(prefix = "com.ohaotian.registrycenter")
public class RegistryCenterProperties implements Serializable {

    private String zkAddressList = "127.0.0.1:2181";

    /**
     * 配置父节点
     */
    private String namespace = "/canal";
    /**
     * 监控节点
     */
    private String listenerNode = namespace + "/data";

    /**
     * 维护节点
     */
    private String nodeInfo = namespace + "/monitor/app";


}
