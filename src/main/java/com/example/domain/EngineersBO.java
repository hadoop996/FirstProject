package com.example.domain;

import lombok.Builder;
import lombok.Data;

/**
 * @author 郝少杰
 * @date 2021/1/28 16:12
 */
@Data
@Builder
public class EngineersBO {
    private String tenantCode;
    private String phone;
    private String name;
    private String nameHeadImg;
    private String channelCode;
    private String channelName;
    private String developerID;
    private String developerName;
}
