package com.example.work;

import com.ailk.ecs.open.esbclient.OpenEsbClient;
import com.ailk.ecs.open.esbclient.bean.EcAopResult;
import com.ailk.ecs.open.esbclient.bean.SysParamBean;
import com.ailk.ecs.open.esbclient.sign.SignAlgorithmType;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.domain.BroadbandBO;
import com.example.utils.AesUtils;
import com.example.utils.JsonUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhangxh
 * @since 2020-04-20.
 */
@Slf4j
public class SafetyDemo {

    //测试密钥
    final static private String secret = "22Pbd7157KhLr8Ry";
    //生产
//    final static private String secret = "D2XG78VG30yojwca";

    public static void main(String[] args) throws Exception {
        /**
         * 初始化客户端
         */
        String url = "http://ecstest0517.10010.com/oppf";
        //创建应用时选择的签名加密方式
        SignAlgorithmType type = SignAlgorithmType.HmacSHA256;
        //创建应用后应用基本信息中的密钥
        String signSecurty = "d89a800186440b8b778153ae697ae780";
        OpenEsbClient client = new OpenEsbClient(url,type,signSecurty);
        /**
         * 系统参数
         */
        SysParamBean sysParamBean = new SysParamBean();
        //应用ID，创建应用后可在开发者视图查阅
        //sysParamBean.setAppId("5...6");
        sysParamBean.setAppId("210126089");
        //系统流水号，要求值唯一
        sysParamBean.setBusiSerial(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        //默认选择格式为json
        sysParamBean.setFormat("json");
        //选择接入的能力编码，可位于开发者视图能力查询处查阅
        sysParamBean.setMethod("uac.oauth2.broadInfo");
        //接入版本，如未作额外通知默认填写1
        sysParamBean.setVersion("1");
        /**
         * 业务参数
         */
        JSONObject busi = new JSONObject();
        busi.put("user_id", "17610623205");
        busi.put("display", "uop:oauth2.0:token");
        busi.put("redirect_uri", "uop:oauth2.0:token");
        busi.put("timestamp","1616063700671");

        /**
         * 调用接口
         */
        EcAopResult result = client.call(sysParamBean,busi);
        /**
         * 接口返回
         */
        if (result==null){
            log.error("<==========调接口返回空");
        }
        com.alibaba.fastjson.JSONObject resultObject = JSON.parseObject(result.getResponse());
        if (resultObject==null){
            log.error("<==========通过手机号获取装机地址失败：响应为空");
        }
        com.alibaba.fastjson.JSONObject resultData = resultObject.getJSONObject("result");
        if (resultData==null){
            log.error("<==========通过手机号获取装机地址失败：响应为空");
        }
        String broadbandBOS=  resultData.getString("broadbandinfo");
        List<Object> list = JsonUtils.toList(broadbandBOS);

        ObjectMapper objectMapper = new ObjectMapper();
        CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, BroadbandBO.class);
        List<BroadbandBO> rspList = objectMapper.readValue(objectMapper.writeValueAsBytes(list), listType);

        for (BroadbandBO broadbandBO : rspList) {
            String decrypt = AesUtils.decrypt(broadbandBO.getInstalladdress(), secret);
            log.error("用户{},装机地址:{}",broadbandBO.getCustname(),decrypt);
        }

//        System.out.println("调用方流水号(BusiSerial)：" + (StringUtils.isBlank(result.getApptx()) ? sysParamBean.getBusiSerial() : result.getApptx()));
//        System.out.println("开放平台系统流水号(Txid):" + result.getTxid());
//        System.out.println("http状态码:" + result.getStatusCode());
//        System.out.println("返回报文:" + result.getResponse());
    }

}
