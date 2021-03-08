//package com.example.controller;
//
//import com.example.config.RspBO;
//import com.example.utils.AesUserEngineerRelUtil;
//import net.sf.json.JSONObject;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Controller;
//import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @author 郝少杰
// * @date 2020/12/29 14:40
// */
//
//@RestController
//@RequestMapping("/engineer")
//public class SmartEngineerController {
//    private final Logger log = LoggerFactory.getLogger(this.getClass());
//
//    @Value("${broadband.enkey}")
//    private String enkey ;
//    @Value("${broadband.iv}")
//    private String iv ;
//
//    @Value("${IS_TEST:false}")
//    private boolean isTest;
//
//    @RequestMapping("/synthesizeReport")
//    public RspBO synthesizeReport(@RequestBody JSONObject jsonObject){
//        log.info("综合报表加密参数，入参{}",jsonObject);
//        if (!jsonObject.isEmpty()&& !StringUtils.isEmpty(jsonObject.get("engineer"))){
//            String encryption = AesUserEngineerRelUtil.hexEncode(AesUserEngineerRelUtil.aesEncrypt(jsonObject.toString().getBytes(), AesUserEngineerRelUtil.hexDecode(enkey), AesUserEngineerRelUtil.hexDecode(iv)));
//            return RspBO.success(encryption);
//        }else {
//            return RspBO.fail("获取参数失败");
//        }
//    }
//
//    @RequestMapping("/get")
//    public void getIsTest(){
//        System.out.println(isTest);
//    }
//
//    @RequestMapping("/userManager")
//    public RspBO userManager(@RequestBody JSONObject jsonObject){
//        log.info("用户管理加密参数，入参{}",jsonObject);
//        if (!jsonObject.isEmpty()){
//            //通过手机号获取developid
//            String devlelopid = "123";
//            jsonObject.put("devlelopid",devlelopid);
//            String encryption = AesUserEngineerRelUtil.aesDecrypt(AesUserEngineerRelUtil.hexDecode(jsonObject.toString()), AesUserEngineerRelUtil.hexDecode(enkey), AesUserEngineerRelUtil.hexDecode(iv));
//            return RspBO.success(encryption);
//        }else {
//            return RspBO.fail("获取参数失败");
//        }
//    }
//
//    public static void main(String[] args) {
//
//    }
//
//}
