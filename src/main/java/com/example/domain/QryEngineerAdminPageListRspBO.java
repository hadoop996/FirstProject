package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author:huangwei
 * @createTime:2020/12/24 14:37
 * @description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QryEngineerAdminPageListRspBO implements Serializable {

    private static final long serialVersionUID = -5292184788558143880L;
    /**
     * 姓名
     */
    private String name;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 账号角色
     */
    private String accountRole;

    /**
     * 账号角色名称
     */
    private String accountRoleName;
    /**
     * ECS账号(平台账号)
     */
    private String ecsAccount;
    /**
     * 省份编码
     */
    private String provinceCode;
    /**
     * 省份名称
     */
    private String provinceName;
    /**
     * 地市编码
     */
    private String cityCode;
    /**
     * 地市名称
     */
    private String cityName;
    /**
     * 渠道编码
     */
    private String channelCode;
    /**
     * 渠道名称
     */
    private String channelName;

    /**
     * 备注
     */
    private String note;

}
