package com.example.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author:huangwei
 * @createTime:2020/10/12 15:10
 * @description:
 */
@Data
public class EngineerBO implements Serializable {
    private static final long serialVersionUID = 6892427788763274622L;
    /**
     * 工程师工号,目前为电话号码
     */
    private String id;
    /**
     * 工程师电话号码
     */
    private String mobile;
    /**
     * 工程师姓名
     */
    private String name;
    /**
     * 工程师省分
     */
    private String province;
    /**
     * 工程师地市
     */
    private String city;
    /**
     * 工程师状态（在职、离职)等 目前为空
     */
    private String state;
    /**LYN新加字段
     * 装维人员发展人编码（唯一标示，为空不计入统计）**/
    private  String developId ;
    /**LYN新加字段
     * 装维人员发展人姓名**/
    private  String developName ;
    /**LYN新加字段
     * 发展人工号**/
    private  String developStaffId ;
    /**LYN新加字段
     * 发展人渠道编码**/
    private  String developDepartId ;
    /**LYN新加字段
     * 发展人渠道名称**/
    private  String developDepartName ;
}
