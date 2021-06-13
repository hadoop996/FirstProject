package com.example.work;

import com.ailk.ecs.open.esbclient.OpenEsbClient;
import com.ailk.ecs.open.esbclient.bean.EcAopResult;
import com.ailk.ecs.open.esbclient.bean.SysParamBean;
import com.ailk.ecs.open.esbclient.sign.SignAlgorithmType;
import com.example.utils.SystemClock;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author zhangxh
 * @since 2020-04-20.
 */
@Slf4j
public class MarketDoTaskDemo {

    private static SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");

    public static void main(String[] args) throws Exception {
        /**
         * 初始化客户端
         */
        String url = "http://ecstest0517.10010.com/oppf";
        //创建应用时选择的签名加密方式
        SignAlgorithmType type = SignAlgorithmType.HmacSHA256;
        //创建应用后应用基本信息中的密钥
        //String signSecurty = "037637f1fadda428b3fe6b30b2050ddc";
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
        sysParamBean.setMethod("uac.oauth2.newtoken");
        //接入版本，如未作额外通知默认填写1
        sysParamBean.setVersion("1");
        /**
         * 业务参数
         */
        Map busi = new HashMap();

        busi.put("grant_type", "token");
        busi.put("ticket", "iojblfctc73b3d2a4b3317e2118c7213e979dfdbjor4eawc");
        /**
         * 调用接口
         */
        long l = SystemClock.currentTimeMillis();
        EcAopResult result = client.call(sysParamBean,busi);
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
