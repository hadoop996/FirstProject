package com.example.work;

import com.alibaba.fastjson.JSONObject;
import com.example.constans.AbilityPlatformConstants;
import com.example.domain.po.abilityPlatform.AbilityPlatformPO;
import com.example.domain.po.abilityPlatform.DATA;
import com.example.domain.po.abilityPlatform.TInstallPersonSyncAbilityplatform;
import com.example.utils.HaoKaoSignUtil;
import com.example.utils.HttpUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class Route {
    public static void main(String[] args) {
        String appId = "k4KYgtD3My";
        String appSecret = "oUzXDEHgfKNhkR3uGv1CFJFHzsImkXQE";
        String syncAbilityInsertUrl = "http://10.124.150.230:8000/api/microservice/routes/qryrouteall/v1";
        JSONObject jsonReqBo = new JSONObject();
        Map<String, Object> map = new HashMap<>();
        try {
            map.put("APP_ID", appId);
            map.put("key", appSecret);
            //加密方法
            HaoKaoSignUtil.buildAppParams(map);
            log.info("HaoKaoSignUtil：{}", JSONObject.toJSONString(map));
            JSONObject UNI_BSS_ATTACHED = new JSONObject();
            UNI_BSS_ATTACHED.put("MEDIA_INFO", "");
            JSONObject UNI_BSS_HEAD = new JSONObject();
            UNI_BSS_HEAD.put("APP_ID", "k4KYgtD3My");
            UNI_BSS_HEAD.put("TIMESTAMP", map.get("TIMESTAMP").toString());
            UNI_BSS_HEAD.put("TRANS_ID", map.get("TRANS_ID").toString());
            UNI_BSS_HEAD.put("TOKEN", map.get("TOKEN").toString());

            JSONObject UNI_BSS_BODY = new JSONObject();
            JSONObject QRYROUTEALL_REQ = new JSONObject();
            JSONObject REQ = new JSONObject();

            jsonReqBo.put("UNI_BSS_BODY", UNI_BSS_BODY);
            jsonReqBo.put("UNI_BSS_HEAD", UNI_BSS_HEAD);
            jsonReqBo.put("UNI_BSS_ATTACHED", UNI_BSS_ATTACHED);

            REQ.put("ROUTE_VALUE", "01016229349");
            REQ.put("NET_TYPE_CODE", "40");
            QRYROUTEALL_REQ.put("REQ", REQ);
            UNI_BSS_BODY.put("QRYROUTEALL_REQ", QRYROUTEALL_REQ);

            String json = jsonReqBo.toJSONString();
            log.info("请求参数：{}", json);

            String resJson = HttpUtils.doPostJson(syncAbilityInsertUrl, json);
            log.info("响应返回参数：{}", resJson);

            // 解析返回值
            parseResJson(resJson);
        } catch (NoSuchAlgorithmException e) {
            log.error("HaoKaoSignUtil解析Map失败：{}", e.getMessage());
        } catch (UnsupportedEncodingException e) {
            log.error("HaoKaoSignUtil解析Map失败：{}", e.getMessage());
        }
    }


    /**
     * 解析能力平台响应结果为 AbilityPlatformPO 实体
     *
     * @param resJson
     * @return
     */
    private static void parseResJson(String resJson) {
        AbilityPlatformPO abilityPlatformPO = null;
        List<DATA> date = null;
        try {
            abilityPlatformPO = JSONObject.parseObject(resJson, AbilityPlatformPO.class);
            log.info("==========>>>>>JSONObject.parseObject成功解析：{}", abilityPlatformPO);
            String resp_code = abilityPlatformPO.getUNI_BSS_HEAD().getRESP_CODE();
            String resp_desc = abilityPlatformPO.getUNI_BSS_HEAD().getRESP_DESC();

            String status = abilityPlatformPO.getUNI_BSS_BODY().getQRYROUTEALL_RSP().getSTATUS();
            String msg = abilityPlatformPO.getUNI_BSS_BODY().getQRYROUTEALL_RSP().getMSG();

            String rsp_code = abilityPlatformPO.getUNI_BSS_BODY().getQRYROUTEALL_RSP().getRSP().getRSP_CODE();
            String rsp_desc = abilityPlatformPO.getUNI_BSS_BODY().getQRYROUTEALL_RSP().getRSP().getRSP_DESC();
            String sub_code = abilityPlatformPO.getUNI_BSS_BODY().getQRYROUTEALL_RSP().getRSP().getSUB_CODE();
            String sub_desc = abilityPlatformPO.getUNI_BSS_BODY().getQRYROUTEALL_RSP().getRSP().getSUB_DESC();
            log.info("resp_code：{}, resp_desc：{}, status：{}, status：{}, rsp_code：{} " +
                            "rsp_code：{} rsp_code：{} rsp_code：{}", resp_code, resp_desc, status, msg, rsp_code
                    , rsp_desc, sub_code, sub_desc);

            if (AbilityPlatformConstants.UNI_BSS_HEAD_RESP_CODE.equals(resp_code)) {
                log.info("====================调能力平台接口请求成功====================");
                if (AbilityPlatformConstants.UNI_BSS_BODY_SUCCESS.equals(status)) {
                    log.info("====================能力平台服务调用成功====================");
                    if (AbilityPlatformConstants.UNI_BSS_BODY_SUCCESS.equals(rsp_code) &&
                            AbilityPlatformConstants.UNI_BSS_BODY_SUCCESS.equals(sub_code)) {
                        log.info("====================能力平台执行成功====================");
                        date = abilityPlatformPO.getUNI_BSS_BODY().getQRYROUTEALL_RSP().getRSP().getDATA();
                        System.out.println(date.get(0));
                    }
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

}