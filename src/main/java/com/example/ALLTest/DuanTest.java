package com.example.ALLTest;

import com.alibaba.fastjson.JSONObject;
import com.example.constans.ResultData;
import com.example.utils.JsonUtils;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;

public class DuanTest {
    public static ResultData queryUserRisk(String type,String phone) {
        String[] phoneList = {"01", "06", "12", "14", "19", "20", "23", "24", "25", "27", "28", "29"};
        if (StringUtils.isEmpty(type)||StringUtils.isEmpty(phone)||!Arrays.asList(phoneList).contains(type)){
            return ResultData.success("获取用户信息失败");
        }
        JSONObject parameter = new JSONObject();
        parameter.put("phone", phone);
        String resJson = null;
        try {
            String checkRiskUrl = "https://omotest.10010.com:30051/service/common/userManage/queryCheckRiskByPhone";
            resJson = HttpUtils.doPostJson(checkRiskUrl, parameter.toString());
        }catch (Exception e){
            return ResultData.success("断卡行动校验接口异常");
        }
        if (!StringUtils.isEmpty(resJson)){
            JSONObject jsonObject = JSONObject.parseObject(resJson);
            String code = jsonObject.getString("code");
            if (!StringUtils.isEmpty(code)&&"0000".equals(code)){
                String data = jsonObject.getString("data");
                JSONObject jsonData = JSONObject.parseObject(data);
                String riskIdentification = jsonData.getString("riskIdentification");
                String riskPhone = jsonData.getString("phoneList");
                if (!StringUtils.isEmpty(riskIdentification)&&!StringUtils.isEmpty(riskPhone)){
                    List<String> riskPhoneList = JsonUtils.toList(riskPhone);
                    if (!StringUtils.isEmpty(riskPhoneList.get(0))){
                        if ("1".equals(riskIdentification)){
                            return ResultData.error("您登录的号码当前存在信息安全风险，请立即进行实人认证，以免影响您的正常使用。");
                        }else if ("2".equals(riskIdentification)){
                            return ResultData.error("您名下的"+riskPhoneList.get(0)+"号码当前存在信息安全风险，请您使用该号码登录中国联通APP立即进行实人认证，以免影响该号码的正常使用。");
                        }else if ("3".equals(riskIdentification)){
                            return ResultData.success("成功");
                        }else {
                            return ResultData.success("断卡行动返回参数类型不存在");
                        }
                    }else {
                        return ResultData.success("断卡行动返回手机号不存在");
                    }
                }else {
                    return ResultData.success("断卡行动参数列表缺失");
                }
            }else {
                return ResultData.success("断卡行动校验接口返回异常");
            }
        }else {
            return ResultData.success("断卡行动校验接口返回为空");
        }
    }

    public static void main(String[] args) {
        ResultData resultData = queryUserRisk("01", "13261100668");
        System.out.println(resultData.getCode()+"--"+resultData.getMessage()+"--"+resultData.getData());
    }
}
