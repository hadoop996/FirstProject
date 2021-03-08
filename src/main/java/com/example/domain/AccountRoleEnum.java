package com.example.domain;

import lombok.Getter;

/**
 * @author:huangwei
 * @createTime:2020/12/24 15:24
 * @description:
 */
@Getter
public enum AccountRoleEnum {

    SUPER_ADMIN("00", "超级管理员"),
    PROVINCE_ADMIN("01", "省份管理员"),
    CITY_ADMIN("02", "市级管理员"),
    TEAM_ADMIN("03", "智家团队管理员");

    private final String code;
    private final String desc;

    AccountRoleEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static AccountRoleEnum codeOf(String code) {
        for (AccountRoleEnum accountRoleEnum : values()) {
            if (accountRoleEnum.getCode().equals(code)) {
                return accountRoleEnum;
            }
        }
        return null;
    }

    public static AccountRoleEnum descOf(String value) {
        for (AccountRoleEnum accountRoleEnum : values()) {
            if (accountRoleEnum.getDesc().equals(value)) {
                return accountRoleEnum;
            }
        }
        return null;
    }
}
