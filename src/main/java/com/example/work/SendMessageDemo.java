package com.example.work;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.example.constans.BusinessCode;
import com.example.domain.GetMessageCodeReqBO;
import com.example.domain.GetMessageCodeRspBO;
import com.example.eumes.VerifyCodeEnum;
import com.example.utils.JsonUtils;
import com.example.utils.ValidBatchUtils;
import com.example.utils.VerifyUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ObjectUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 郝少杰
 * @date 2021/4/14 15:52
 */
@Slf4j
public class SendMessageDemo {

    final private static String url = "http://sms5.10010.com:10002/send";
    final private static String user = "000085";
    final private static String pwd = "vAH2AEFq4195";
    final private static String tid = "16768";

    public static void main(String[] args) throws Exception {
        GetMessageCodeReqBO getMessageCode = new GetMessageCodeReqBO();
        getMessageCode.setMobile("18612081018");
        getMessageCode(getMessageCode);
    }

    public static void getMessageCode(GetMessageCodeReqBO getMessageCodeReqBO) throws Exception {

        log.info("-----------------使用2i接口发送短信-------");
        // 参数校验
        List<String> checkRes = ValidBatchUtils.checkParams(getMessageCodeReqBO);
        if (checkRes.size() != 0) {
            log.error("失败明细：{}，===》{}",BusinessCode.QUERY_VALI_FALID, checkRes.toString());
            return;
        }
        if (!ValidBatchUtils.isPhoneNumber(getMessageCodeReqBO.getMobile())) {
            log.error("失败明细：{}，===》{}",BusinessCode.QUERY_VALI_FALID, "手机号格式错误");
            return;
        }
        try {
            String key = String.format(Constants.Code.MESSAGE_CODE_KEY, getMessageCodeReqBO.getMobile());
            GetMessageCodeRspBO res = GetMessageCodeRspBO.builder()
                    .overtime("300")
                    .success(true).build();
            log.info("====获取验证码的key===={}", key);
            String messageCode = VerifyUtil.getNumberCode(VerifyCodeEnum.SIX);
            String msg = "杰哥你好（测试）";
            sendMessage2i(getMessageCodeReqBO.getMobile(), msg);
        }catch (Exception e){
            log.error("获取短信失败");
        }
    }

    public static void sendMessage2i(String phone, String msg)  {
        log.info("------------进入发短信方法---------2i的url",url);
        try {
            long l = System.currentTimeMillis() / 1000;
            log.info("当前的时间戳" + l);
            String key = plainToMd5L32(user + l + pwd).substring(0, 16);
            Map<String, Object> map = new HashMap<>();
            map.put("user", user);
            map.put("tick", l);
            map.put("tid", tid);
            map.put("m", phone);
            map.put("key", key);
            map.put("c", msg);
            String url2I = url+(getUrlParamsByMap(map));
            log.info("2i请求地址{}",url2I);
            log.info("2i的user{}",user);
            log.info("2i的pwd{}",pwd);
            log.info("2i的tid{}",tid);
            log.info("2i的key" + key + "key的长度是" + key.length());
            log.info("2i的tick{}",l);
            String rspMsg = HttpUtil.get(url2I);
            JSONObject json = JSONObject.parseObject(rspMsg);
            String code = (String) json.get("code");
            String erroMsg = (String) json.get("msgid");
            if (!"0".equals(code)) {
                log.info("------------调用2i接口发送短信接口错误,msg-------------{}", erroMsg);
                log.info("------------调用2i接口发送短信接口错误,code-------------{}", code);
            } else {
                log.info("------------调用2i接口发送短信接口成功-------------{}", erroMsg);
            }
        }catch (Exception e){
            log.info("------------2i接口发送短信接口错误-------------{}",e.getMessage());
        }
    }


    /**
     * 将map转换成url
     *
     * @param map
     * @return
     */
    public static String getUrlParamsByMap(Map<String, Object> map) {
        if (map == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            sb.append(entry.getKey() + "=" + entry.getValue());
            sb.append("&");
        }
        String s = sb.toString();
        if (s.endsWith("&")) {
            s = StringUtils.substringBeforeLast(s, "&");
        }
        return "?" + s;
    }

    /**
     * @param plain
     * @return
     * @Description: 32位小写MD5
     */
    public static String plainToMd5L32(String plain) throws Exception {
        if (StringUtils.isEmpty(plain)) {
            return null;
        }
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("MD5算法异常");
        }
        byte[] bytes = md5.digest(plain.getBytes());
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bytes) {
            int bt = b & 0xff;
            if (bt < 16) {
                stringBuffer.append(0);
            }
            stringBuffer.append(Integer.toHexString(bt));
        }
        return stringBuffer.toString();
    }

}
