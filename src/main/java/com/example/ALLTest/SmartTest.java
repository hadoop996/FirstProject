package com.example.ALLTest;

import com.alibaba.fastjson.JSONObject;
import com.example.domain.EncodeEngineerReqBO;
import com.example.utils.AesUserEngineerRelUtil;

/**
 * @author 郝少杰
 * @date 2021/1/5 23:21
 */
public class SmartTest {
    public static void test(EncodeEngineerReqBO encodeEngineerReqBO){
        String encodeStr = encodeEngineerReqBO.getEncodeStr();
        String json = AesUserEngineerRelUtil.aesDecrypt(AesUserEngineerRelUtil.hexDecode(encodeStr),
                AesUserEngineerRelUtil.hexDecode("a095c8e01cdc7abaa85ebca832e4ca57"), AesUserEngineerRelUtil.hexDecode("7bf502cebdce578d67c333fcc5631067"));
//        JSONObject jsonObject = JSONObject.parseObject(json);
        System.out.println(json);
    }

    public static void main(String[] args) {
        EncodeEngineerReqBO encodeEngineerReqBO = new EncodeEngineerReqBO();
        encodeEngineerReqBO.setEncodeStr("c0be9cbf2b4e2cb032ece017953b5c0faaddfb80b8acd325ad56e469b05397dc59bf3c17d663181e62909a98289365fe32b8cc65de606c102516486fb3726246");
        test(encodeEngineerReqBO);
    }
}
