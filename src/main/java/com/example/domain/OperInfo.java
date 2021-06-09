package com.example.domain;

import lombok.Data;

/**
 * @ClassName:
 * @Description:
 * @Author: zhanglw92@chinaunicom.cn
 * @Data: 2019/8/5 14:41
 */
@Data
public class OperInfo {
    //操作员ID
    String operId;
    //渠道ID
    String channelId;
    //渠道类型
    String channelType;
    //省分编码
    String provinceCode;
    //地市编码
    String eparchyCode;
    //区县编码
    String cityCode;
    /*//发起方机构编码
    String initiatorCode;
    //发起方应用域代码
    String origDomain;*/
    //电信类型编码
    String serviceClassCode;
    //区号
    String areaCode;
}
