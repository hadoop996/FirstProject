package com.example.utils;


import com.example.eumes.VerifyCodeEnum;

/**
 * 验证码工具类
 * <p>支持生成数字验证码，字母数字混合验证码，字母验证码</p>
 *
 * @author Cloud(郭云峰)
 * @date 2021/2/5 14:36
 */
public class VerifyUtil {

    private VerifyUtil(){

    }

    public static final char[] MIX_VERIFICATION_CODE={
            48,49,50,51,52,53,54,55,56,57,
            65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,
            97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122
    };

    public static final char[] CHARACTER_VERIFICATION_CODE={
            65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,
            97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122
    };

    public static final char[] LOWCASE_CHARACTER_VERIFICATION_CODE={
            97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122
    };

    /**
     * 创建一个指定长度的数字验证码，返回一个 {@code int[]} 数组
     * <p>出于安全起见，创建长度需要指定使用枚举类中的长度</p>
     * <p>数字范围 {@code 0} 到 {@code 9} </p>
     * <p>更新时间: {@date 2021/2/5 14:36}</p>
     * @param size 验证码长度枚举类
     * @return 包含指定数量随机数字的 {@code String} 字符串
     * @see VerifyCodeEnum
     */
    public static String getNumberCode(VerifyCodeEnum size){
        StringBuffer codeStr=new StringBuffer();

        for (int i = 0; i < size.getSize(); i++) {
            codeStr.append((int)(Math.random()*10));
        }
        return codeStr.toString();
    }

    /**
     * 创建长度为四的数字验证码，返回一个 {@code int[]} 数组
     * <p>出于安全起见，创建长度需要指定使用枚举类中的长度</p>
     * <p>数字范围 {@code 0} 到 {@code 9} </p>
     * <p>更新时间: {@date 2021/2/5 14:36}</p>
     * @return 包含四个随机数字的 {@code String} 字符串
     * @see VerifyCodeEnum
     */
    public static String getNumberCode(){
        return getNumberCode(VerifyCodeEnum.FOUR);
    }

    /**
     * 创建一个指定长度的混合验证码，返回一个 {@code char[]} 数组
     * <p>出于安全起见，创建长度需要指定使用枚举类中的长度</p>
     * <p>更新时间: {@date 2021/2/5 14:36}</p>
     * <p>数字范围 {@code 0-9} {@code A-Z} {@code a-z} </p>
     * @param size 验证码长度枚举类
     * @return 包含指定数量随机字符的 {@code int[]} 数组
     * @see VerifyCodeEnum
     */
    public static char[] getMixCode(VerifyCodeEnum size){
        int sourceLength=MIX_VERIFICATION_CODE.length;
        char[] code=new char[sourceLength];
        for (int i = 0; i < size.getSize(); i++) {
            code[i]=MIX_VERIFICATION_CODE[(int)(Math.random()*sourceLength)];
        }
        return code;
    }

    /**
     * 创建一个指定长度的字母验证码，返回一个 {@code char[]} 数组
     * <p>出于安全起见，创建长度需要指定使用枚举类中的长度</p>
     * <p>更新时间: {@date 2021/2/5 14:36}</p>
     * <p>数字范围
     * @param size 验证码长度枚举类
     * @return 包含指定数量随机字符的 {@code int[]} 数组
     * @see VerifyCodeEnum
     */
    public static char[] getCharacterCode(VerifyCodeEnum size){
        int sourceLength=CHARACTER_VERIFICATION_CODE.length;
        char[] code=new char[sourceLength];
        for (int i = 0; i < size.getSize(); i++) {
            code[i]=CHARACTER_VERIFICATION_CODE[(int)(Math.random()*sourceLength)];
        }
        return code;
    }
}
