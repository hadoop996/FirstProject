package com.example.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description 请求类型
 * @Author lss
 * @Date 2020/11/27 12:18
 */
@Data
public class EncodeEngineerReqBO implements Serializable {

    private static final long serialVersionUID = -5886113814018828519L;
    /**
     * 请求参数加密串
     */
    private String encodeStr;
}
