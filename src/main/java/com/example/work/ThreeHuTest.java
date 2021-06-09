//package com.example.work;
//
//import com.alibaba.druid.util.StringUtils;
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.example.domain.CheckUserInfoReq;
//import com.example.domain.CheckUserInfoRsp;
//import com.example.domain.OperInfo;
//import com.example.domain.SerialNumberRouteRsp;
//import com.example.utils.MapTool;
//import lombok.extern.slf4j.Slf4j;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//@Slf4j
//public class ThreeHuTest {
//
//    private String CHECK_USER_INFO_NORTH_URL;
//
//    private String CHECK_USER_INFO_SOUTH_URL;
//
//    private final String API_NAME = "CHECK_USER_INFO";
//
//    //北6 获取用户的客户、用户与账户基本信息
//    private final String INFO_TAG = "1111011110100011011";//"111101010000001101";
//
//    //南25 获取用户的客户、用户与账户基本信息
//    private final String GET_MODE = "101000001000";
//
//    public Map<String,Object> checkUserInfoMethod2(OperInfo operInfo, String serialNumber, String tradeTypeCode){
//        String url = null;
//        Map<String,Object> param = null;
//        Map<String, Object> resultMap = null;
//        CheckUserInfoRsp checkUserInfoRsp = null;
//
//        SerialNumberRouteRsp serialNumberRouteRsp = serialNumberRouteService.querySerialNumberRoute(serialNumber);
//        log.info("调用三户接口，号码路由信息：{}", JSON.toJSONString(serialNumberRouteRsp));
//        if(StringUtils.equals(serialNumberRouteRsp.getRespCode(),"0000")){
//
//            String provinceCode = serialNumberRouteRsp.getProvinceCode();
//            String system = serialNumberRouteRsp.getNumberSystem();
//
//            CheckUserInfoReq checkUserInfoReq = new CheckUserInfoReq();
//
//            checkUserInfoReq.setTradeTypeCode(tradeTypeCode);
//            checkUserInfoReq.setOrderType("00");
//            checkUserInfoReq.setCityCode(operInfo.getCityCode());
//            checkUserInfoReq.setChannelId(operInfo.getChannelId());
//            checkUserInfoReq.setSerialNumber(serialNumber);
////            checkUserInfoReq.setInfoTag("100000000000001");
////            checkUserInfoReq.setInstitutionCode("9900");
//            checkUserInfoReq.setAccessType("99");
//            checkUserInfoReq.setInitiatorCode("H200");
//            checkUserInfoReq.setEparchyCode(operInfo.getEparchyCode());
//            checkUserInfoReq.setOrigDomain("CLZX");
//            checkUserInfoReq.setOperId(operInfo.getOperId());
//            checkUserInfoReq.setChannelType(operInfo.getChannelType());
//            checkUserInfoReq.setRouteType("00");
//            checkUserInfoReq.setRouteValue("99");
//            checkUserInfoReq.setProvinceCode(operInfo.getProvinceCode());
//            checkUserInfoReq.setServiceClassCode(operInfo.getServiceClassCode());
//            checkUserInfoReq.setAreaCode(operInfo.getAreaCode());
//
//            List<CheckUserInfoReq.PARA> paraList = new ArrayList<>();
//            CheckUserInfoReq.PARA para = new CheckUserInfoReq.PARA();
//            para.setParaId("OPERATE_FLAG");
//            para.setParaValue("AOP_KD_DISCNT");
//            paraList.add(para);
//            checkUserInfoReq.setPara(paraList);
//
//            try {
//                //测试用
//            /*checkUserInfoReq.setInfoTag(INFO_TAG);
//            checkUserInfoReq.setInstitutionCode("9900");
//            url = CHECK_USER_INFO_NORTH_URL;*/
//
//                //cbss号码
//                if(StringUtils.equals(serialNumberRouteRsp.getNumberSystem(),"00")){
//                    checkUserInfoReq.setInfoTag(INFO_TAG);
//                    checkUserInfoReq.setInstitutionCode("9900");
//                    url = CHECK_USER_INFO_NORTH_URL;
//                }
//                //bss号码
//                else {
//                    checkUserInfoReq.setInstitutionCode(provinceCode+"00");
//                    checkUserInfoReq.setRouteValue(provinceCode);
//                    //北6（北京、山东、河北、河南、辽宁、黑龙江）
//                    if(StringUtils.equals(provinceCode,"11") || StringUtils.equals(provinceCode,"17") || StringUtils.equals(provinceCode,"18") ||
//                            StringUtils.equals(provinceCode,"76") || StringUtils.equals(provinceCode,"91") || StringUtils.equals(provinceCode,"97") ){
//                        checkUserInfoReq.setInfoTag(INFO_TAG);
//                        url = CHECK_USER_INFO_NORTH_URL;
//                    }
//                    //南25
//                    else{
//                        checkUserInfoReq.setGetMode(GET_MODE);
//                        checkUserInfoReq.setServiceClassCode("0000");
//                        url = CHECK_USER_INFO_SOUTH_URL;
//                    }
//                }
//
//                param = MapTool.Obj2Map(checkUserInfoReq);
//                resultMap = capacityPlatformService.invokeCapacityPlatform(url, API_NAME, param);
//
//            } catch (Exception e){
//                e.printStackTrace();
//            }
//
//            log.info("调用三户接口，出参：{}", JSONObject.toJSONString(checkUserInfoRsp));
//        }
//
//        return resultMap;
//    }
//
//}
