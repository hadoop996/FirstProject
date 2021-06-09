package com.example.work;

import com.ailk.ecs.open.esbclient.OpenEsbClient;
import com.ailk.ecs.open.esbclient.bean.EcAopResult;
import com.ailk.ecs.open.esbclient.bean.SysParamBean;
import com.ailk.ecs.open.esbclient.sign.SignAlgorithmType;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.domain.BroadbandBO;
import com.example.domain.CardBroadbandBO;
import com.example.utils.AesUtils;
import com.example.utils.JsonUtils;
import com.example.utils.RsaCrypt;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.ohaotian.plugin.base.exception.ZTBusinessException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 郝少杰
 * @date 2021/4/25 11:49
 */
@Slf4j
public class QueryBroadBandByIDCard {
    //测试密钥
    final static private String secret = "22Pbd7157KhLr8Ry";
    public static void main(String[] args) throws Exception {
        /**
         * 初始化客户端
         */
//        String url = "http://open.10010.com/oppf";
        String url = "http://ecstest0517.10010.com/oppf";
        //创建应用时选择的签名加密方式
        SignAlgorithmType type = SignAlgorithmType.HmacSHA256;
        //创建应用后应用基本信息中的密钥
        String signSecurty = "d89a800186440b8b778153ae697ae780";
//        String signSecurty = "71173e0b4f2dbdc23e9e6a7d54954839";

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
        sysParamBean.setMethod("uac.oauth2.cardInfo");
        //接入版本，如未作额外通知默认填写1
        sysParamBean.setVersion("1");
        /**
         * 业务参数
         */
        JSONObject busi = new JSONObject();
        busi.put("cert_num", "210124198710240634");
        busi.put("cert_type", "02");
        busi.put("province_code", "11");
        busi.put("city_code","110");
        busi.put("display","native");
        busi.put("redirect_uri","uop:oauth2.0:token");
//        busi.put("real_ip","10.3.31.181");
        busi.put("req_time",System.currentTimeMillis());
        if(true){
            busi.put("service_type","BROAD_BAND_INFO");
        }else{
            busi.put("service_type","IPTV_INFO");
        }

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
            log.error("<==========获取证件号码下的宽带列表失败：响应为空");
        }
        com.alibaba.fastjson.JSONObject resultData = resultObject.getJSONObject("result");
        if (resultData==null){
            log.error("<==========通过手机号获取装机地址失败：响应为空");
        }
        String broadbandBOS = resultData.getString("broadbandinfo");
        if (StringUtils.isBlank(broadbandBOS)){
            log.error("<==========broadbandinfo为空");
            throw new ZTBusinessException("broadbandinfo为空");
        }
        List<Object> list = JsonUtils.toList(broadbandBOS);
        ObjectMapper objectMapper = new ObjectMapper();
        CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, CardBroadbandBO.class);
        List<CardBroadbandBO> rspList = objectMapper.readValue(objectMapper.writeValueAsBytes(list), listType);

        if (rspList.isEmpty()){
            log.error("<==========返回结果List为空");
            throw new ZTBusinessException("返回结果List为空");
        }
        for (CardBroadbandBO cardBroadbandBO : rspList) {
            String decrypt = RsaCrypt.decrypt(cardBroadbandBO.getInstalladdr());
            log.error("用户{},装机地址:{},宽带:{}",cardBroadbandBO.getUsername(),decrypt,cardBroadbandBO.getBroadbandcode());
        }

        System.out.println("调用方流水号(BusiSerial)：" + (StringUtils.isBlank(result.getApptx()) ? sysParamBean.getBusiSerial() : result.getApptx()));
        System.out.println("开放平台系统流水号(Txid):" + result.getTxid());
        System.out.println("http状态码:" + result.getStatusCode());
        System.out.println("返回报文:" + result.getResponse());

    }
}
