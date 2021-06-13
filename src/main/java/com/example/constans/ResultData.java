package com.example.constans;

import java.io.Serializable;

/**
 * @Author: wltt
 * @Date: 2019/6/10 14:03
 * @Version: 1.0
 * @Description: TODO
 */
public class ResultData<T> implements Serializable {

    /**
     * 0成功；1失败
     */
    private String code;

    private String message;

    private T data;


    public ResultData() {
    }
    /**
     * 成功时候的调用
     */
    public static <T> ResultData<T> success(T data) {
        return new ResultData<T>(BusinessCode.SUCCESS,data);
    }


    public ResultData(BusinessCode businessCode, T data) {
        if (businessCode != null) {
            this.setCode(businessCode.getCode());
            this.setMessage(businessCode.getMessage());
        }
        this.data = data;
    }

    private ResultData(BusinessCode businessCode) {
        if (businessCode != null) {
            this.setCode(businessCode.getCode());
            this.setMessage(businessCode.getMessage());
        }
    }

    private ResultData(String message) {
        this.setCode(BusinessCode.FAILD.getCode());
        this.setMessage(message);
    }

    private ResultData(String message, T data) {
        this.setCode(BusinessCode.FAILD.getCode());
        this.setMessage(message);
        this.setData(data);
    }

    public static <T> ResultData<T> error(BusinessCode codeMsg) {
        return new ResultData<T>(codeMsg);
    }


    public static <T> ResultData<T> error(BusinessCode codeMsg,String message) {
        ResultData resultData = new ResultData<T>(codeMsg);
        resultData.setMessage(message);
        return resultData;
    }


    public static <T> ResultData<T> error(BusinessCode businessCode, T data) {
        return new ResultData<T>(businessCode, data);
    }

    public static <T> ResultData<T> error(String message) {
        return new ResultData<T>(message);
    }

    public static <T> ResultData<T> error(String message,T data) {
        return new ResultData<T>(message,data);
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
