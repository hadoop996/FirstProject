//package com.example.work;
//
//import com.example.ALLTest.HttpClientUtil;
//import org.json.JSONObject;
//
//import static org.apache.commons.codec.digest.MessageDigestAlgorithms.MD5;
//
//public class QueryBroadBandByCustID {
//    public static void main(String[] args) {
//        String url = "http://132.46.140.20:6906/Customer/querycustomerMsg";
//        String transactionId = "SOKD31nASC20160101101937x93z92";
//        JSONObject JSONObject = new JSONObject();
//        JSONObject.put("appKey","SOKD31nASC");
//        JSONObject.put("apiName","unicom.user.query.all");
//        JSONObject.put("transactionId",transactionId);
//        JSONObject.put("sign","2018-01-01 10:19:37");
//        JSONObject.put("timestamp",MD5(transactionId+dataJson+secret));
//        JSONObject.put("data","");
//
//
//        String sendHttpPost = HttpClientUtil.getInstance().sendHttpPost(url);
//        System.out.println(sendHttpPost);
//
//    }
//}
