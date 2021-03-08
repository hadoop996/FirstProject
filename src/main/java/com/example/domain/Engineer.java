package com.example.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 郝少杰
 * @date 2021/2/2 11:37
 */
@Data
public class Engineer implements Serializable {
    private String id;
    private String mobile;
    private String name;
    private String province;
    private String city;
    private String state;
    private String developId;
    private String developName;
    private String developStaffId;
    private String developDepartId;
    private String developDepartName;
}
