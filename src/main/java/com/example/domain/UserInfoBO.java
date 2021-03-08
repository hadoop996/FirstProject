package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author:huangwei
 * @createTime:2020/10/12 15:06
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInfoBO implements Serializable {
    private static final long serialVersionUID = 1422116644310125557L;
    /**
     * 用户宽带账号
     */
    private String number;
    /**
     * 用户名称
     */
    private String name;
    /**
     * 装机地址
     */
    private String address;
    /**
     * 用户联系电话
     */
    private String mobile;
    /**
     * 当前套餐id
     */
    private String productId;
    /**
     * 当前套餐名称
     */
    private String productName;
    /**
     * 证件类型
     */
    private String cardType;
    /**
     * 用户身份证号
     */
    private String cardId;
    /**
     * 用户省份
     */
    private String province;
    /**
     * 用户地市
     */
    private String city;


}
