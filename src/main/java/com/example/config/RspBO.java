package com.example.config;

import lombok.Data;

import java.io.Serializable;

@Data
public class RspBO<T> implements Serializable {
    private String code;
    private String message;
    private T data;


    public RspBO(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public RspBO() {
    }

    /**
     * 成功时候的调用
     */
    public static <T> RspBO<T> success(T data) {
        return new RspBO<T>(BusinessCode.SUCCESS, data);
    }

    /**
     * 成功时候的调用
     */
    public static <T> RspBO<T> success() {
        return new RspBO<T>(BusinessCode.SUCCESS);
    }

    public static <T> RspBO<T> successOther(T data) {
        return new RspBO<T>(BusinessCode.SUCCESS_OTHER, data);
    }

    public RspBO(BusinessCode businessCode, T data) {
        if (businessCode != null) {
            this.setCode(businessCode.getCode());
            this.setMessage(businessCode.getMessage());
        }
        this.data = data;
    }

    private RspBO(BusinessCode businessCode) {
        if (businessCode != null) {
            this.setCode(businessCode.getCode());
            this.setMessage(businessCode.getMessage());
        }
    }

    private RspBO(String message) {
        this.setCode(BusinessCode.FAILD.getCode());
        this.setMessage(message);
    }

    public static <T> RspBO<T> fail(BusinessCode codeMsg) {
        return new RspBO<T>(codeMsg);
    }

    public static <T> RspBO<T> fail(BusinessCode codeMsg, String message) {
        RspBO RspBO = new RspBO<T>(codeMsg);
        RspBO.setMessage(message);
        return RspBO;
    }

    public static <T> RspBO<T> fail(BusinessCode businessCode, T data) {
        return new RspBO<T>(businessCode, data);
    }

    public static <T> RspBO<T> fail(String message) {
        return new RspBO<T>(message);
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
        this.setCode(BusinessCode.SUCCESS.getCode());
        this.setMessage(BusinessCode.SUCCESS.getMessage());
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
