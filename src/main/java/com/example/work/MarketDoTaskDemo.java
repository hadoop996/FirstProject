package com.example.work;

import com.ailk.ecs.open.esbclient.OpenEsbClient;
import com.ailk.ecs.open.esbclient.bean.EcAopResult;
import com.ailk.ecs.open.esbclient.bean.SysParamBean;
import com.ailk.ecs.open.esbclient.sign.SignAlgorithmType;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author zhangxh
 * @since 2020-04-20.
 */
public class MarketDoTaskDemo {

    private static SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");

    public static void main(String[] args) throws Exception {
        /**
         * 初始化客户端
         */
        String url = "http://132.38.0.85:80/oppf";
        //创建应用时选择的签名加密方式
        SignAlgorithmType type = SignAlgorithmType.HmacSHA256;
        //创建应用后应用基本信息中的密钥
        //String signSecurty = "037637f1fadda428b3fe6b30b2050ddc";
        String signSecurty = "71173e0b4f2dbdc23e9e6a7d54954839";
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
        sysParamBean.setMethod("uac.oauth2.newtoken");
        //接入版本，如未作额外通知默认填写1
        sysParamBean.setVersion("1");
        /**
         * 业务参数
         */
        Map busi = new HashMap();

        busi.put("grant_type", "token");
        busi.put("ticket", "aa1go2ag77644c3fb4313a6b99ed85e06126f987hmlu1vjl");
        /**
         * 调用接口
         */
        EcAopResult result = client.call(sysParamBean,busi);
        /**
         * 接口返回
         */
        System.out.println("statusCode:" + result.getStatusCode());
        System.out.println("返回：:" + result.getResponse());
        System.out.println("txid:" + result.getTxid());
    }
}
