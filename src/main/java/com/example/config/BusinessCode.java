/**
 * @Author liuzhenhua
 * @Date: 2019年07月23日
 * @Copyright: 北京天源迪科信息技术有限公司，禁止外泄以及用于其他的商业目的 Inc. All rights reserved.
 */
package com.example.config;

/**
 * @author liuzhenhua
 * @since 2019-07-23
 */
public enum BusinessCode {


    SUCCESS("0000", "操作成功"),
    SUCCESS_OTHER("1010", "没有此类商家，为您推荐更多商家"),
    FAILD("9999", "系统异常"),
    THREE_HUNDREDAND_ONE("301", "资源(网页等)被永久转移到其它URL"),
    FOUR_HUNDRED("400", "请求的资源(网页等)不存在"),
    FIVE_HUNDRED("500", "内部服务器错误"),
    VLAUE_ERROR("8888", "前台传值有误"),
    NOT_VALUE("9090", "暂无数据"),
    NUMBER_EXIST("N031", "号码不存在");


    private String code;
    private String message;

    BusinessCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
