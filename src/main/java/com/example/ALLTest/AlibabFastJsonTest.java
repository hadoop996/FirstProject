package com.example.ALLTest;


import lombok.extern.slf4j.Slf4j;

/**
 * @author 郝少杰
 * @date 2021/4/12 15:55
 */
@Slf4j
public class AlibabFastJsonTest {
    public static void main(String[] args) {
        String a = "'12312312312";
        String replace = a.replace("\'", "");
        System.out.println(replace);
//        String a = "{\"phone\":\"18618473899\"}";
//        com.alibaba.fastjson.JSONObject jsonObject = com.alibaba.fastjson.JSONObject.parseObject(a);
//        System.out.println(jsonObject);

    }
}
