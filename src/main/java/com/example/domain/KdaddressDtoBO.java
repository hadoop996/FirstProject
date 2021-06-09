package com.example.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class KdaddressDtoBO implements Serializable {

    private static final long serialVersionUID = 822318368874112497L;
    /**
     * 装机省份编码
     */
    private String provinceCode;
    /**
     * 装机省份名称
     */
    private String provinceName;

    /**
     * 装机地市编码
     */
    private String cityCode;

    /**
     * 装机地市名称
     */
    private String cityName;

    /**
     * 装机区县编码
     */
    private String districtCode;

    /**
     * 装机区县名称
     */
    private String districtName;

    /**
     * 地址详情
     */
    private String addressDetail;

    /**
     * 宽带号码
     */
    private String kdID;

    /**
     * 渠道编码
     */
    private String channelCode;

    /**
     * 发展人编码
     */
    private String developerID;

    /**
     * 工程师手机号
     */
    private String engineerPhone;

    /**
     * 工程师名称
     */
    private String engineerName;
}
