package com.example.utils;

import com.alibaba.fastjson.JSONObject;

import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @Author: wltt
 * @Date: 2020/6/12 14:46：
 * @Version: 1.0
 * @Description: TODO
 */
public class RBase64 {
    public RBase64() {
    }

    public static String encode(byte[] bytes) {
        return DatatypeConverter.printBase64Binary(bytes);
    }

    public static byte[] decode(String base64str) {
        return DatatypeConverter.parseBase64Binary(base64str);
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userPhone","123");
        jsonObject.put("userBroadcast","321");
        String encode = encode(jsonObject.toString().getBytes());
        System.out.println(encode);
        String str = new String(decode(encode), "utf-8");
        System.out.println(str);
    }
}
