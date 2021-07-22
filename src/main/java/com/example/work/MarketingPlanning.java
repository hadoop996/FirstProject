package com.example.work;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSONObject;

/**
 * @author hsj
 * @createTime 2021年07月20日 10:30:00
 * 线上线下一体化查询用户画像+策略接口
 */
public class MarketingPlanning {
    /**
     *
     * @param args
     */

    public static void main(String[] args) {
        //http://132.46.12.18:5903
        String url = "http://127.0.0.1:5904/recommend/service/onandoffline/cust/data/v3";
        JSONObject JsonObject = new JSONObject();
        JSONObject JsonObject2 = new JSONObject();
        JsonObject2.put("channelCode","100009");
        JsonObject2.put("currentTime","20210719180135");
        JsonObject2.put("traceId","10000920210719060135271161162668");

        JsonObject.put("commonInfo",JsonObject2);
        JsonObject.put("params","3051396e7c7d1d15f7c6472cf7a1326e34291f9541dd85b22ea9573ec23e03d4f11d72d4dda2fd2fe5fa4e0d2e2c9ea494f77b2823f584901db933029ae5e13e5bd26c02bfabc7faf81ea98503a9c0e088d4dd54f18b4a256c27af8260378852930d8da5522169a734044dc804855f22");

        String rspJson = HttpRequest.post(url)
                .keepAlive(false)
                .body(JsonObject.toJSONString())
                .execute().body();
        System.out.println(rspJson);
    }
}
