package com.example.http;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfoPO implements Serializable {
    /**
     * 用户业务号码
     */
    private String serialNumber;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private String sex;

    /**
     * 省份
     */
    private String provinceCode;

    /**
     * 地市
     */
    private String cityCode;

    /**
     * 网别（30:固话 40:宽带 50:移网）
     */
    private String netTypeCode;

    /**
     * 装机地址
     */
    private String acctAddress;
}
