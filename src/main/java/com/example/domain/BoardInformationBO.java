package com.example.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: renchenkai
 * @Date: 2020/11/25 16:52：
 * @Version: 1.0
 * @Description: TODO
 */
@Data
public class BoardInformationBO implements Serializable {
    private static final long serialVersionUID = -5976709911908922793L;
    /**
     * 宽带统一编码
     */
    private String serialnumber;
    /**
     * 装机地址
     */
    private String installaddress;
    /**
     * 联系电话
     */
    private String linkphone;
    /**
     * 客户名称
     */
    private String custname;
    /**
     * 宽带账号
     */
    private String accountnet;
    /**
     * 联系人姓名
     */
    private String username;
}
