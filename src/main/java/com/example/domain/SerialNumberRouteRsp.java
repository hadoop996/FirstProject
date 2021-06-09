package com.example.domain;
import lombok.Data;

/**
 * @author: huangzj70
 * @description: no description
 * @date: 2019/4/17 17:42
 */
@Data
public class SerialNumberRouteRsp {

    /**
     * 响应码
     */
    private String respCode;

    /**
     * 响应的错误信息
     */
    private String respDesc;

    /**
     * 省分编码
     */
    private String provinceCode;

    /**
     * 地市编码
     */
    private String eparchyCode;

    /**
     * 号码归属系统：00-cbss1.0系统，01-bss号码
     */
    private String numberSystem;

}
