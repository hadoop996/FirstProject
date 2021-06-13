package com.example.work;

import com.ailk.ecs.ssp.eop.api.EopClient;
import com.ailk.ecs.ssp.eop.api.EopReq;
import com.ailk.ecs.ssp.eop.api.EopRsp;
import com.example.domain.BoardInformationBO;
import com.example.domain.EopEntityBO;
import com.example.utils.DateUtil;
import com.example.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ObjectUtils;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 郝少杰
 * @date 2021/4/6 21:36
 */

@Slf4j
public class GetUserBroadBandInfo {
    // 服务端URL地址
    //http://132.38.1.82:7207/ssp-gateway-release
    private static String url = "http://127.0.0.1:7209/ssp-gateway-release";
    //渠道接入唯一标识码
    private static String appcode = "152000001";
    // Md5密钥
    private static String signKey = "bhgjDQRazK4bNAof1F0jnyITv0TmGdvENrHC9+eIWG0k5KKpg1Ag9DMXMdOyuB5d9NWX/dLNxKZ5FBX/UCOBNQ==";
    // Md5加密类型
    private static String signType = "hmac";
    // AES加密密钥
    private static String aesKey = "IRQ50Zz8HqByTo+waEICjw==";
    // RSA加密密钥
    private static String rsaKey = "MIIBVgIBADANBgkqhkiG9w0BAQEFAASCAUAwggE8AgEAAkEAjSww8T8YtScn8zgjufcpPOFP5A2v8pnbKfVTGv225P2C1AIgtjYVbU+2RWr5IjfSZxm7lTkx6nDirj1Pg59uEwIDAQABAkEAi/1yWwhSm/DEMO9Oni51+iUDcAYSn+Pp7OWVD4LgRpmUEBt+2Pldo0bJzIsDF+86TUymXycFV1GDA8ZGUBo2YQIhAMe+AnEKxjDX+29Q0H1O0Gzujaj/4l3ebj6NkH6Kk+h/AiEAtO8k9H5LCxcdrP+1cec3fK2y5gYm7QMcvaoNmhEikG0CIQDB/0YXzMMZhWxrfS5Bxl6grkFgNscBLJwenRgOD0IAuQIga7Ig3ArEXkCPIGdAOCE5bNPzNWmaB9+fXuF2oSrr2O0CIQCnIZTaJ/4EUTv5DXdRyeuWZkvLgtsZOl8dc9foQhvPuw==";
    //主机后3位IP
    private static String ipSuffix = "203";
    //对外业务编码,表示某个服务,cu.query.calldetail:详单查询,详见自助服务平台接入规范
    private static String busiCode = "cu.query.broadbandattnqry";
    //业务编码
    private static String businessCode = "11990000415";
    private static final String provincePrefix = "0";

    public static void main(String[] args) {
        queryUserDetailByNum();
    }
    public static void queryUserDetailByNum() {
        String userBroadcast = "01004719448";
        String province = "11";
        String eparchy = "110";
        String fourArea = "010";
        String queryType = "02";
        log.info("=====================================参数没有问题！");
        StringBuffer engineerProvinceCode = new StringBuffer();
        engineerProvinceCode.append(provincePrefix).append(province);
        log.info("====================================本地存在工程师");

        EopClient client = new EopClient(url, appcode, signKey);
        client.setSignAlgorithm(signType);
        client.setParamKey(aesKey);
        client.setPriKey(rsaKey);
        log.info("=====================================EopClient");

        EopReq eopReq = new EopReq(busiCode);

        log.info("====================================EopReq");
        //密钥版本对象封装(根据自助平台提供的版本号及类型设置)
        Map<String, String> accessMap = new HashMap<String, String>();
        accessMap.put("AES", "0.0.1");
        accessMap.put("HMAC", "0.0.1");
        accessMap.put("RSA", "0.0.1");
        client.setAccessMap(accessMap);
        log.info("=================>密钥版本信息：{}", accessMap);

        // 封装业务参数列表(接口报文体参数,具体接口不同,传值请参见接口规范)
        Map<String, String> bizMap = new HashMap<String, String>();
        bizMap.put("querytype", queryType);//查询类型
        bizMap.put("usernumber", userBroadcast);//查询号码
        bizMap.put("areacode", fourArea);//区号
        eopReq.putSecuret4KeyValue("biz_params", bizMap);//业务参数

        // 封装公共参数列表
        Map<String, String> pubMap = new HashMap<>();
        // 拼接流水号
        StringBuffer sb = new StringBuffer();
        sb.append(appcode).append(businessCode).append(DateUtil.getCurrentDateTime("yyyyMMddHHmmss")).append(ipSuffix);
        sb.append(new DecimalFormat("000000"));
        log.info("打印流水号{}",sb);
        pubMap.put("transid", sb.toString());//唯一标识流水,由调用系统生成
        pubMap.put("channelcode", appcode);//渠道编码
        pubMap.put("businesscode", businessCode);//业务编码
        pubMap.put("customid", userBroadcast);//用户id
        // 省份地市参数仅为测试数据(生产库没有表)
        pubMap.put("provincecode", engineerProvinceCode.toString());//省份编码
        pubMap.put("citycode", eparchy);//地市编码
        pubMap.put("nettype", "99");//网别,如11:4G 具体参见接口规范
        pubMap.put("paytype", "0");//付费类型,如2具体参见接口规范

        //公共参数
        eopReq.put("pub_params", pubMap);
        log.info("===================>业务参数信息：{},busi{}", eopReq.getParams(), bizMap.toString());

        try {
            long l = System.currentTimeMillis();
            EopRsp eopRsp = client.execute(eopReq);
            long l1 = System.currentTimeMillis();
            System.out.println(l=l1);
            System.out.println("失败："+eopRsp.getRspdesc());
            String rspResults = String.valueOf(eopRsp.getResult());
            log.info("===================>调用接口返回信息：{}", rspResults);
            if (StringUtils.isEmpty(rspResults)) {
                log.error("调ECS接口，返回结果为空不可绑定用户{}",userBroadcast);
            }
            EopEntityBO eopEntityBO = JsonUtils.toBean(rspResults, EopEntityBO.class);
            List<BoardInformationBO> boardinfo = null;
            if (eopEntityBO != null) {
                boardinfo = eopEntityBO.getBoardinfo();
            }
            if (ObjectUtils.isEmpty(boardinfo)) {
                log.error("调ECS接口，返回用户信息为空不可绑定用户{}",userBroadcast);
            }
            BoardInformationBO boardInformationBO = boardinfo.get(0);
            log.info("===================>取出返回对象中List集合里面的值：{}", boardInformationBO);
            if (StringUtils.isBlank(boardInformationBO.getCustname())){
                log.error("ecs获取用户姓名为空{}",userBroadcast);
            }
            if (StringUtils.isBlank(boardInformationBO.getSerialnumber())){
                log.error("ecs获取宽带编码为空{}",userBroadcast);
            }
            if (StringUtils.isBlank(boardInformationBO.getInstalladdress())){
                log.error("ecs获取装机地址为空{}",userBroadcast);
            }
            if (StringUtils.isBlank(boardInformationBO.getLinkphone())){
                log.error("ecs获取联系人电话为空{}",userBroadcast);
            }
            if (boardInformationBO.getLinkphone().length()>16){
                log.error("用户号码长度异常{}",userBroadcast);
            }
            log.info(boardInformationBO.toString());

        } catch (Exception e) {
            log.error("调用ECS接口失败失败{}",userBroadcast);
            log.error(e.toString());
        }
    }
}
