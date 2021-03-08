package com.example.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 郝少杰
 * @date 2021/2/2 11:37
 */
@Data
public class User implements Serializable {
    private String number;
    private String name;
    private String address;
    private String mobile;
    private String productId;
    private String productName;
    private String cardType;
    private String cardId;
    private String province;
    private String city;
}
