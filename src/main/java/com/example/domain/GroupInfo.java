package com.example.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class GroupInfo implements Serializable {
    /**
     * 是否为主号码
     * 0主号码
     * 1成员号码
     */
    private String main_num_flag;

    /**
     * 成员名称
     */
    private String member_user_name;

    /**
     * 成员网别
     */
    private String service_class_code;

    /**
     * 成员号码
     */
    private String serial_number;
}
