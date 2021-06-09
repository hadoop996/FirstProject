package com.example.domain;

import lombok.Data;

import java.util.List;

/**
 * @ClassName:
 * @Description:
 * @Author: zhanglw92@chinaunicom.cn
 * @Data: 2019/8/5 14:32
 */
@Data
public class CheckUserInfoReq {
    private String routeType;          //路由类型
    private String routeValue;         //路由关键值
    private String institutionCode;    //接收方机构编码
    private String operId;             //操作员ID
    private String origDomain;         //发起方应用域代码
    private String initiatorCode;      //发起方机构编码
    private String provinceCode;       //省分代码
    private String eparchyCode;        //地市编码
    private String cityCode;           //区县编码
    private String channelId;          //渠道编码
    private String channelType;        //渠道类型
    private String accessType;         //接入类型 01 WEB； 02 短信； 03 WAP；04 IVR； 05 自助终端；06 MINI营业厅；07客户端；08 第三方平台；09 网上商城 10 WO+APP 99 其他
    private String orderType;          //订单提交类型 00:直接提交 01:预提交
    private String tradeTypeCode;      //业务受理类型
    private String serviceClassCode;   //电信类型编码，编码见附录
    private String areaCode;           //区号
    private String serialNumber;       //服务号码
    private String simCardNo;          //USIM卡号

    /*获取信息列表标志集：
        INFO_TAG_SET 各位含义如下，为1时取对应资料，其他不取
         第1位：获取用户主表信息
         第2位：获取用户扩展属性信息
         第3位：获取客户核心资料信息
         第4位：获取客户个性资料信息(个人 或 集团)
         第5位：获取客户扩展属性信息
         第6位：获取账户核心资料信息
         第7位：获取账户托收资料信息
         第8位：获取账户属性信息
         第9位：获取购机信息
         第10位：获取担保信息
         第11位：获取资源信息
         第12位：获取积分信息
         第13位：获取用户异动信息
         第14位：获取邮寄信息
         第15位：获取用户关系信息
         第16位：获取用户产品信息
         第17位：获取用户活动信息
         第18位：获取用户优惠信息
         第19位：获取用户服务信息
         第20位：获取用户sp信息
         第21位：获取客户vip信息
         第22位：获取集团客户信息
         第23位：获取共线号码信息
         第24位：获取用户抽奖信息
         第25位：获取用户装机资源信息
         第26位：获取用户押金信息
         第27位：获取用户扩展信息
         第28位：获取账户优惠及属性信息
         第29位：获取pps用户异动信息
         第30位：获取客户积分信息
         第31位：获取购机属性信息
         第32位：获取用户领奖信息
         第33位：获取集团代付规则表
    */
    private String infoTag;  //cb和北6用此字段

    /*
        第1位：客户信息，对应输出参数中的CUST_INFO；
        第2位：大客户信息，对应输出参数中的VIP_CUST_INFO；
        第3位：用户信息，对应输出参数中的USER_INFO；
        第4位：共线号码信息，对应输出参数中的SAME_LINE_INFO；
        第5位：子产品信息，对应输出参数中的PRODUCT_INFO；
        第6位：活动信息，对应输出参数中的ACTIVITY_INFO；
        第7位：欠费信息，对应输出参数中的ARREARAGE_FEE_INFO；
        第8位：装机资源信息，对应输出参数中的RESOUREC_INFO；
        第9位：账户信息，对应输出参数中的ACCT_INFO；
        第10位：银行托收信息，对应输出参数中的CONSIGN；
        第11位：押金信息，对应输出参数中的FOREGIFT_FEE_INFO；
        第12位：邮寄信息，对应输出参数中的POST；
    */
    private String getMode;  //南25用此字段

    private String userState;                       //0:正常用户 1：预约销户用户 2：正式销户用户 9：所有
    private String userPasswd;                      //用户密码
    private String userId;                          //
    private List<PARA> para;                        //保留字段

    //保留字段
    @Data
    static public class PARA {
        private String paraId;                                //保留字段ID
        private String paraValue;                             //保留字段值
    }
}
