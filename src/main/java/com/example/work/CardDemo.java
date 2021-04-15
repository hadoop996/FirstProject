package com.example.work;

import com.ailk.ecs.ssp.eop.api.EopClient;
import com.ailk.ecs.ssp.eop.api.EopReq;
import com.ailk.ecs.ssp.eop.api.EopRsp;
import com.alibaba.fastjson.JSON;
import com.example.domain.GatWayPo;
import com.example.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author 郝少杰
 * @date 2021/4/7 20:27
 */
@Slf4j
public class CardDemo {

    private static final String url = "http://127.0.0.1:7209/ssp-gateway-release";
    private static final String appcode = "152000001";
    private static final String signKey = "bhgjDQRazK4bNAof1F0jnyITv0TmGdvENrHC9+eIWG0k5KKpg1Ag9DMXMdOyuB5d9NWX/dLNxKZ5FBX/UCOBNQ==";
    private static final String signType = "hmac";
    private static final String aesKey = "IRQ50Zz8HqByTo+waEICjw==";
    private static final String rsaKey = "MIIBVgIBADANBgkqhkiG9w0BAQEFAASCAUAwggE8AgEAAkEAjSww8T8YtScn8zgjufcpPOFP5A2v8pnbKfVTGv225P2C1AIgtjYVbU+2RWr5IjfSZxm7lTkx6nDirj1Pg59uEwIDAQABAkEAi/1yWwhSm/DEMO9Oni51+iUDcAYSn+Pp7OWVD4LgRpmUEBt+2Pldo0bJzIsDF+86TUymXycFV1GDA8ZGUBo2YQIhAMe+AnEKxjDX+29Q0H1O0Gzujaj/4l3ebj6NkH6Kk+h/AiEAtO8k9H5LCxcdrP+1cec3fK2y5gYm7QMcvaoNmhEikG0CIQDB/0YXzMMZhWxrfS5Bxl6grkFgNscBLJwenRgOD0IAuQIga7Ig3ArEXkCPIGdAOCE5bNPzNWmaB9+fXuF2oSrr2O0CIQCnIZTaJ/4EUTv5DXdRyeuWZkvLgtsZOl8dc9foQhvPuw==";
    private static String busiCode = "cu.query.mydetailinfo";
    private static String businessCode = "11132000001";

    public static void main(String[] args) {
        GatWayPo gatWayPo = new GatWayPo("0531","017","170",
                "13","2","01017033324");
        testGatWay(gatWayPo);
    }

    public static void testGatWay(GatWayPo gatWayPo) {
        EopClient client = new EopClient(url, appcode, signKey);
        client.setSignAlgorithm(signType);
        client.setParamKey(aesKey);
        client.setPriKey(rsaKey);
        //密钥版本对象封装(根据自助平台提供的版本号及类型设置)
        Map<String, String> accessMap = new HashMap<String, String>();
        accessMap.put("AES", "0.0.1");
        accessMap.put("HMAC", "0.0.1");
        accessMap.put("RSA", "0.0.1");
        client.setAccessMap(accessMap);
        EopReq eopReq = new EopReq(busiCode);
        // 封装业务参数列表(接口报文体参数,具体接口不同,传值请参见接口规范)
        Map<String, String> bizMap = new HashMap<String, String>();
        bizMap.put("usernumber", gatWayPo.getUsernumber());//详单查询服务会收到短信,请用自己的测试号码
        bizMap.put("telareacode",gatWayPo.getTelareacode());//固网区号
        eopReq.putSecuret4KeyValue("biz_params", bizMap);//业务参数,具体参见自助服务平台接入规范

        log.error("封装业务参数bizMap列表{}", JSON.toJSONString(bizMap));
        StringBuffer transid = new StringBuffer();
        transid.append(appcode).append(businessCode).append(DateUtil.getCurrentDateTime("yyyyMMddHHmmssSSS")).append(randomCode());
        // 封装公共参数列表
        Map<String, String> pubMap = new HashMap<String, String>();
        pubMap.put("transid", transid.toString());//唯一标识流水,由调用系统生成,格式:渠道编码+业务编码+yyyyMMddHHmmssSSS+6位自定
        pubMap.put("customid", "11111111111");//用户id,如果无法获取,默认11个1
        pubMap.put("channelcode", appcode);//渠道编码,如111000001:网厅,详见基础数据,新接入渠道需要联系自助分配 1
        pubMap.put("businesscode", businessCode);//业务编码,如11112000088:4G后付费通话详单查询,详见基础数据 1
        pubMap.put("provincecode", gatWayPo.getProvincecode());//省份编码
        pubMap.put("citycode", gatWayPo.getCitycode());//地市编码
        pubMap.put("nettype", gatWayPo.getNettype());//网别,如11:4G 具体参见接口规范 如果没有登录认证无法获取网别,默认99
        pubMap.put("paytype", gatWayPo.getPaytype());//付费类型,如2  具体参见接口规范 如果没有登录认证无法获取网别,默认0
        eopReq.put("pub_params", pubMap);//公共参数
        log.error("公共参数pubMap列表{}", JSON.toJSONString(pubMap));
        try {
            EopRsp eopRsp = client.execute(eopReq);
            //rspcode返回为0000时表示成功
            if ("0000".equals(eopRsp.getRspcode())) {
                Map result = eopRsp.getResult();
                //result为应答报文封装对象,对应业务规范
                System.out.println(result);
                log.info("result为应答报文封装对象,对应业务规范{}", result);
            } else {
                //其他编码是错误编码,此时不取result
                System.out.println("错误编码:" + eopRsp.getRspcode() + ",错误描述" + eopRsp.getRspdesc());
                log.info("其他编码是错误编码,此时不取result{}", eopRsp.getRspcode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String randomCode() {
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            str.append(random.nextInt(10));
        }
        return str.toString();
    }
}
