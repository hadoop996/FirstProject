package com.example.worknew;

import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import com.ailk.ecs.open.esbclient.OpenEsbClient;
import com.ailk.ecs.open.esbclient.bean.EcAopResult;
import com.ailk.ecs.open.esbclient.bean.SysParamBean;
import com.ailk.ecs.open.esbclient.sign.SignAlgorithmType;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.utils.SystemClock;
import com.ohaotian.plugin.base.exception.ZTBusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class TicketToToken {
    private static SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");

    private static String newToken = "new_token";
    private static String userInfo = "user_info";
    private static String cardInfo = "cardInfo";
    private static String broadInfo = "broadInfo";
    private static String redirectUri = "uop:oauth2.0:token";
    private static String display = "native";
    private static String grantTypeToken = "userinfo";
    private static String grantTypeTicket = "token";
    private static String certType = "02";
    private static String appCode = "ECS_KDSZH";
    private static String appSecret = "4e30e1ee533543c599c33ef7fb";
    private static String Ecsurl = "http://127.0.0.1:10004/oauth2/";


    public static void main(String[] args) throws Exception {
        String ticket = "jsgjvv6p46d36242ef9611ddc875b4883f8729a29ksymbdp";
        String rspJson = null;
        try {
            if (StringUtils.isEmpty(ticket)){
                throw new ZTBusinessException("获取ticket失败");
            }
            Map JsonObject = new HashMap<>();
            JsonObject.put("app_code", appCode);
            JsonObject.put("app_secret", appSecret);
            JsonObject.put("grant_type", grantTypeTicket);
            JsonObject.put("ticket", ticket);

            String url = Ecsurl + newToken;
            long startTime = SystemClock.currentTimeMillis();
            rspJson = HttpRequest.post(url)
                    .header(Header.CONTENT_TYPE,"application/x-www-form-urlencoded")
                    .timeout(5000)
                    .keepAlive(false)
                    .form(JsonObject)
                    .execute().body();
            log.info("<==========通过ticket获取token开始，获取参数：{},耗时：{}",rspJson,SystemClock.currentTimeMillis()-startTime);
        }catch (Exception e){
            log.error("调用手厅接口，通过ticket获取touken接口失败:{}",e.getMessage());
            e.printStackTrace();
        }
    }
}
