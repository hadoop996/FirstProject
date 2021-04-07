package com.example.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: renchenkai
 * @Date: 2020/11/20 11:35：
 * @Version: 1.0
 * @Description: TODO
 */
@Data
public class QueryUserDetailByNumRspBO implements Serializable {

    private static final long serialVersionUID = -4930419419171152030L;
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 用户号码
     */
    private String userBroadcast;
    /**
     * 宽带地址
     */
    private String installAddr;
    /**
     *联系电话
     */
    private String userPhone;
    /**
     *判断返回数据是否报错 0报错 1正常
     */
    private String flag;
    /**
     *存储报错信息用于返回excel
     */
    private String failExcel;
}
