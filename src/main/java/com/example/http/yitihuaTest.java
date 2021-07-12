package com.example.http;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.utils.HttpClientUtil;
import com.example.utils.JsonUtils;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class yitihuaTest {
    public static void main(String[] args) {
        String integrationUrl = "https://omotest.10010.com:30051/service/common/userManage/getUserInfo";
        try {
            JSONObject JsonObject = new JSONObject();
            JsonObject.put("serialNumber", "047508708126");
            JsonObject.put("netTypeCode", "40");
            log.info("一体化获取用户宽带信息入参：{}", JsonObject);

            String json = JsonObject.toJSONString();
            String rspJson = HttpRequest.post(integrationUrl)
                    .keepAlive(false)
                    .body(json)
                    .execute().body();
            JSONObject resultObject = JSON.parseObject(rspJson);

            UserInfoPO userInfoPO = JSONUtil.toBean(resultObject.getString("data"), UserInfoPO.class);
            System.out.println(userInfoPO);

            System.out.println(rspJson);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
