package com.example.eumes;

/**
 * 这里写描述
 *
 * @author Cloud(郭云峰)
 * @date 2021/2/5 15:20
 */
public enum VerifyCodeEnum {

    FOUR(4),
    SIX(6);

    private Integer size;

    private VerifyCodeEnum(Integer size){
        this.size=size;
    }

    public Integer getSize(){
        return this.size;
    }
}
