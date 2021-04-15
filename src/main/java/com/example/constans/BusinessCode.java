/**
 * @Author liuzhenhua
 * @Date: 2019年07月23日
 * @Copyright: 北京天源迪科信息技术有限公司，禁止外泄以及用于其他的商业目的 Inc. All rights reserved.
 */
package com.example.constans;


/**
 * @author liuzhenhua
 * @since 2019-07-23
 */
public enum BusinessCode {


    SUCCESS("0000", "操作成功"),
    FAILD("9999", "系统异常"),
    OPER_ADD_USER_FALID("USER_0000", "新增用户失败！"),
    OPER_QUERY_USER_FALID("USER_0001", "查询用户信息失败！"),
    OPER_QUERY_EVALUATE_FALID("USER_0002", "查询评价信息失败！"),
    QUERY_VALI_FALID("1000", "查询参数校验失败");

    private String code;
    private String message;

    BusinessCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
