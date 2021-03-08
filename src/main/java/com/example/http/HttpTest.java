package com.example.http;

import com.alibaba.fastjson.JSONObject;
import com.example.config.RspBO;
import com.example.domain.EngineerBO;
import com.example.domain.UserInfoBO;
import com.example.utils.AesUserEngineerRelUtil;
import com.example.utils.GsonUtil;
import com.example.utils.HttpClientUtil;
import com.example.utils.HttpUtil;
import com.google.common.collect.Maps;
import com.ohaotian.plugin.base.exception.ZTBusinessException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.httpclient.HttpStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ObjectUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * @author 郝少杰
 * @date 2021/1/21 17:46
 */
@Slf4j
public class HttpTest {

    public static void main(String[] args)throws Exception {
        String sysDataUrl = "http://132.38.3.66/mobileserviceimportantsfyfb/broad/EngineerData";

        String enkey = "b75072a4b0d040d69e1a624181d9babe";

        String iv = "8c4e994c235f4242b30b02d34beec03a";

        String tranId = UUID.randomUUID().toString().replaceAll("-", "");
        //需要的工程师信息
        EngineerBO engineer = new EngineerBO();
        engineer.setId("18322339149");
        engineer.setMobile("18322339149");
        engineer.setName("郭强");
        engineer.setProvince("11");
        engineer.setCity("110");
        engineer.setState("1");
        //新加工程师相关数据开始

        engineer.setDevelopId("1109106546");
        engineer.setDevelopName("");
        engineer.setDevelopStaffId("");
        engineer.setDevelopDepartId("");
        engineer.setDevelopDepartName("");
        //新加相关数据结束
        //需要的用户信息
        UserInfoBO user = new UserInfoBO();
        user.setNumber("123123");
        user.setName("123");
        user.setAddress("大族广场");
        user.setMobile("13932993456");
        user.setProvince("11");
        user.setCity("110");

        Map<String, Object> parMap = Maps.newHashMap();
        //yyyy-MM-dd HH:mm:ss 转换的时间格式  可以自定义
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        //转换
        String bindTime = sdf.format(new Date());
        parMap.put("bindTime", bindTime);
        parMap.put("engineer", engineer);
        parMap.put("user", user);

        //调用同步手厅接口，将数据进行同步
        String jsonPro = GsonUtil.toJson(parMap);

        //将接口参数加密
        String enStr = AesUserEngineerRelUtil.hexEncode(AesUserEngineerRelUtil.aesEncrypt(
                jsonPro.getBytes(), AesUserEngineerRelUtil.hexDecode(enkey),
                AesUserEngineerRelUtil.hexDecode(iv)));

        Map<String, String> paramsMap = Maps.newHashMap();
        paramsMap.put("data", enStr);
        paramsMap.put("tranId", tranId);
        log.info("parameter加密后为==>data" + enStr);
        String rspJson = HttpUtil.doPost(sysDataUrl, (status, res) -> {
            log.info("请求访问的url为：" + sysDataUrl);
            log.info("接口相应响应码：" + status);
            if (status == HttpStatus.SC_OK) {
                return res;
            } else {
                throw new ZTBusinessException("调用手厅接口同步数据失败！");
            }
        }, paramsMap);
        //判断返回结果
        log.info("调用手厅返回结果为：" + rspJson);
    }
}
