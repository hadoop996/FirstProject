package com.example.work;

import com.ailk.ecs.open.esbclient.OpenEsbClient;
import com.ailk.ecs.open.esbclient.bean.EcAopResult;
import com.ailk.ecs.open.esbclient.bean.SysParamBean;
import com.ailk.ecs.open.esbclient.sign.SignAlgorithmType;
import com.alibaba.fastjson.JSONObject;
import com.example.utils.SystemClock;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class TicketToToken {

    public static void main(String[] args) throws Exception {
        String url = "http://ecstest0517.10010.com/oppf";
        String signSecurty = "d89a800186440b8b778153ae697ae780";
        SignAlgorithmType type = SignAlgorithmType.HmacSHA256;
        //获取token
        OpenEsbClient client = new OpenEsbClient(url, type, signSecurty);
        String appId = "210126089";
        String methon = "uac.oauth2.userinfo";
        //系统参数
        SysParamBean sysParamBean = new SysParamBean();
        sysParamBean.setAppId(appId);
        sysParamBean.setBusiSerial(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));

        sysParamBean.setMethod(methon);
        sysParamBean.setVersion("1");
        sysParamBean.setFormat("json");

        String appCode = "ECS-OPEN-NEW";
        String appSercet = "DedQSNMu880nnjnYhW7BnnnA";
        String grantType = "userinfo";
        //content业务参数
        JSONObject busiParam = new JSONObject();
        busiParam.put("app_code", appCode);
        busiParam.put("app_secret", appSercet);
        busiParam.put("grant_type", grantType);
        busiParam.put("access_token", "exgctqhc9f6ce14d528decffdcb7fda0ad0517d6vdk7ovz1");

        long l = SystemClock.currentTimeMillis();
        EcAopResult result = client.call(sysParamBean, busiParam);
        long l1 = SystemClock.currentTimeMillis();
        log.info("耗时：{}",l1-l);

        /**
         * 接口返回
         */
        System.out.println("statusCode:" + result.getStatusCode());
        System.out.println("返回：:" + result.getResponse());
        System.out.println("txid:" + result.getTxid());
    }
}
