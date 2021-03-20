//package com.example.H5;
//
//import java.text.SimpleDateFormat;
//
//import com.ailk.ecs.open.esbclient.OpenEsbClient;
//import com.ailk.ecs.open.esbclient.bean.EcAopResult;
//import com.ailk.ecs.open.esbclient.bean.SysParamBean;
//import com.ailk.ecs.open.esbclient.sign.SignAlgorithmType;
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//
//import java.util.*;
//
//
///**
// * @author 郝少杰
// * @date 2020/9/8 10:12
// */
//
//
//public class MarketDoTaskDemo {
//
//    public static void main(String[] args) throws Exception {
//        /**
//         * 初始化客户端
//         */
//        String url = "http://132.38.0.85:80/oppf";
//        //创建应用时选择的签名加密方式
//        SignAlgorithmType type = SignAlgorithmType.HmacSHA256;
//        //创建应用后应用基本信息中的密钥
//        String signSecurty = "52dfdd328fd4f42e7e2976030702e7d6";
//        OpenEsbClient client = new OpenEsbClient(url, type, signSecurty);
//        /**
//         * 系统参数
//         */
//        SysParamBean sysParamBean = new SysParamBean();
//        //应用ID，创建应用后可在开发者视图查阅
//        sysParamBean.setAppId("505714");
//        //系统流水号，要求值唯一
//        sysParamBean.setBusiSerial(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
//        //默认选择格式为json
//        sysParamBean.setFormat("json");
//        //选择接入的能力编码，可位于开发者视图能力查询处查阅
//        sysParamBean.setMethod("unicomapp.getmonthly");
//        //接入版本，如未作额外通知默认填写1
//        sysParamBean.setVersion("1");
//        /**
//         * 业务参数
//         */
////        JSONObject jsonObject = new JSONObject();
////        jsonObject.put("mobile", "18612081018");
//        Map<String, String> busi = new HashMap<String, String>();
//        busi.put("mobile", "18612081018");
//        /**
//         * 调用接口
//         */
//        EcAopResult result = client.call(sysParamBean, busi);
//        /**
//         * 接口返回
//         */
////        JSONObject response = JSON.parseObject(result.getResponse());
////        JSONObject resultRsp = JSON.parseObject(response.getString("result"));
////        MemberInfoRsp memberInfoRsp = new MemberInfoRsp();
////        memberInfoRsp.setData(JSONObject.parseObject(resultRsp.getString("data"),MemberInfoPo.class));
////        System.out.println("-----:"+memberInfoRsp.toString());
//
//
//        System.out.println("result:" + result.toString());
//
//        System.out.println("statusCode:" + result.getStatusCode());
//        System.out.println("返回：:" + result.getResponse());
//        System.out.println("txid:" + result.getTxid());
//
//    }
//}
//
