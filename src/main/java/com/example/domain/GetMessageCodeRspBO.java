package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 获取短信验证码请求出参
 *
 * @author Cloud(郭云峰)
 * @date 2021/2/6 17:51
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetMessageCodeRspBO implements Serializable {

    private static final long serialVersionUID = 1755955765932387727L;

    private Boolean success;

    private String overtime;

    private String code;
}
