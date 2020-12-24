package com.example.Test;

import com.example.utils.JsonUtils;
import com.google.common.collect.Maps;

import java.security.SecureRandom;
import java.util.Map;
import java.util.Random;

/**
 * @author 郝少杰
 * @date 2020/11/19 10:50
 */
public class StringTest {
    public static void main(String[] args) {
//        String a = "cluster-hk911";
//        int strStartIndex = a.indexOf("-")+1;
//        String strEndIndex = a.substring(strStartIndex,a.length()-1);
//        System.out.println(strEndIndex.substring(0, strEndIndex.indexOf("-")));
        Map map = Maps.newHashMap();
        map.put("A","b");
        System.out.println(JsonUtils.toString(map));

    }

    /**
     * 生成16位不重复的随机数，含数字+大小写
     *
     * @return
     */
    public static String getGUID() {
        StringBuilder uid = new StringBuilder();
        //产生16位的强随机数
        Random rd = new SecureRandom();
        for (int i = 0; i < 15; i++) {
            //产生0-2的3位随机数
            int type = rd.nextInt(1);
            switch (type) {
                case 0:
                    //0-9的随机数
                    uid.append(rd.nextInt(10));
                    break;
//                case 1:
//                    //ASCII在65-90之间为大写,获取大写随机
//                    uid.append((char)(rd.nextInt(25)+65));
//                    break;
//                case 2:
//                    //ASCII在97-122之间为小写，获取小写随机
//                    uid.append((char)(rd.nextInt(25)+97));
//                    break;
                default:
                    break;
            }
        }
        return uid.toString();
    }

    public static String subString(String str) {

        /* 找出指定的2个字符在 该字符串里面的 位置 */
        int strStartIndex = str.indexOf(",");
//        int strEndIndex = str.();

//        /* index 为负数 即表示该字符串中 没有该字符 */
//        if (strStartIndex < 0) {
//            return "字符串 :---->" + str + "<---- 中不存在 " + strStart + ", 无法截取目标字符串";
//        }
//        if (strEndIndex < 0) {
//            return "字符串 :---->" + str + "<---- 中不存在 " + strEnd + ", 无法截取目标字符串";
//        }
        /* 开始截取 */
//        String result = str.substring(strStartIndex, strEndIndex).substring(strStart.length());
        return null;
    }

}
