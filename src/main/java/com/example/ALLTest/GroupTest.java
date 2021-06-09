package com.example.ALLTest;

import com.alibaba.fastjson.JSONObject;
import com.example.domain.GroupInfo;
import com.example.utils.JsonUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GroupTest {
    public static void main(String[] args) {
        String a = "{\n" +
                "        \"cert_addr\": \"北京市西城区金融大街21号\",\n" +
                "        \"group_info\": {\n" +
                "            \"main_card_flag\": \"\",\n" +
                "            \"con_member_info\": [\n" +
                "                {\n" +
                "                    \"main_num_flag\": \"1\",\n" +
                "                    \"member_user_name\": \"郑乃瑜\",\n" +
                "                    \"service_class_code\": \"0040\",\n" +
                "                    \"serial_number\": \"01016229349\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"main_num_flag\": \"0\",\n" +
                "                    \"member_user_name\": \"郑乃瑜\",\n" +
                "                    \"service_class_code\": \"0050\",\n" +
                "                    \"serial_number\": \"18610090215\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"main_member_info\": [\n" +
                "                {\n" +
                "                    \"main_num_flag\": \"1\",\n" +
                "                    \"member_user_name\": \"郑乃瑜\",\n" +
                "                    \"service_class_code\": \"0050\",\n" +
                "                    \"serial_number\": \"18513802205\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"main_num_flag\": \"1\",\n" +
                "                    \"member_user_name\": \"郑乃瑜\",\n" +
                "                    \"service_class_code\": \"0050\",\n" +
                "                    \"serial_number\": \"18513802605\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"main_num_flag\": \"1\",\n" +
                "                    \"member_user_name\": \"郑乃瑜\",\n" +
                "                    \"service_class_code\": \"0050\",\n" +
                "                    \"serial_number\": \"18513802805\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"main_num_flag\": \"0\",\n" +
                "                    \"member_user_name\": \"郑乃瑜\",\n" +
                "                    \"service_class_code\": \"0050\",\n" +
                "                    \"serial_number\": \"18610090215\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"main_num_flag\": \"0\",\n" +
                "            \"group_id\": \"1118071635444885\",\n" +
                "            \"product_id\": \"90394455\",\n" +
                "            \"group_type\": \"04\",\n" +
                "            \"product_name\": \"北京智慧沃家全家福尊享版\"\n" +
                "        },\n" +
                "        \"credit_vale\": \"\",\n" +
                "        \"package_id\": \"90356346\",\n" +
                "        \"province_code\": \"011\",\n" +
                "        \"groupRelaInfoList\": [\n" +
                "            {\n" +
                "                \"groupName\": \"冰激凌融合套餐\",\n" +
                "                \"groupTypeCode\": \"8930\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"groupName\": \"主副卡群组\",\n" +
                "                \"groupTypeCode\": \"ZF\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"tel_area_code\": \"\",\n" +
                "        \"twoiCard\": \"0\",\n" +
                "        \"last_stat_date\": \"20210608192801\",\n" +
                "        \"product_id\": \"18610090215\",\n" +
                "        \"brand\": \"4G00\",\n" +
                "        \"open_date\": \"20180716140318\",\n" +
                "        \"simcard\": \"8986011880127003651\",\n" +
                "        \"cust_lvl\": \"500\",\n" +
                "        \"subscrb_type\": \"0\",\n" +
                "        \"companyIdN\": \"\",\n" +
                "        \"companyIdF\": \"\",\n" +
                "        \"broad_band_account\": \"\",\n" +
                "        \"custID\": \"113224665530368\",\n" +
                "        \"rsp_desc\": \"正常/成功\",\n" +
                "        \"last_visit_time\": \"2021-06-08 18:37:44\",\n" +
                "        \"is_inuser\": \"0000\",\n" +
                "        \"status\": \"开通\",\n" +
                "        \"manager_contact\": \"\",\n" +
                "        \"broad_band_code\": \"\",\n" +
                "        \"cert_type\": \"02\",\n" +
                "        \"productTypeN\": \"17\",\n" +
                "        \"city_code\": \"110\",\n" +
                "        \"errorFrom\": \"\",\n" +
                "        \"npId\": \"0\",\n" +
                "        \"land_lvl\": \"\",\n" +
                "        \"vpn_name\": \"\",\n" +
                "        \"cust_name\": \"郑乃瑜\",\n" +
                "        \"pay_type\": \"2\",\n" +
                "        \"user_head_img\": \"\",\n" +
                "        \"cust_sex\": \"0\",\n" +
                "        \"user_status\": \"0\",\n" +
                "        \"roam_stat\": \"4\",\n" +
                "        \"net_type\": \"11\",\n" +
                "        \"rsp_code\": \"0000\",\n" +
                "        \"cert_num\": \"c91feee08afc4c5cdd9c34e4e944a77e1e69fd09d0884e4ec9babcd88c4d3093\",\n" +
                "        \"productNamexN\": \"\",\n" +
                "        \"manager_name\": \"\",\n" +
                "        \"productNamexF\": \"\",\n" +
                "        \"product_type\": \"01\",\n" +
                "        \"subscrbid\": \"1118071635444886\",\n" +
                "        \"package_name\": \"4G畅爽冰激凌国内流量套餐-199元/月\",\n" +
                "        \"needverify\": \"\",\n" +
                "        \"productTypeF\": \"\",\n" +
                "        \"user_type_status\": \"0000\"\n" +
                "    }";
        JSONObject jsonObject = JSONObject.parseObject(a);
        List<String> strings = setGroupInfo(jsonObject);
        System.out.println(strings.get(0));
    }

    private static List<String> setGroupInfo(JSONObject jsonObject){
        List<String> groupList = new ArrayList();
        JSONObject groupInfo = jsonObject.getJSONObject("group_info");
        List<Object> conMemberInfo = JsonUtils.toList(groupInfo.getString("con_member_info"));
        List<Object> mainMemberInfo = JsonUtils.toList(groupInfo.getString("main_member_info"));

        ObjectMapper objectMapper = new ObjectMapper();
        if (conMemberInfo.size()>0){
            List<GroupInfo> groupConList = new ArrayList();
            CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, GroupInfo.class);
            try {
                groupConList = objectMapper.readValue(objectMapper.writeValueAsBytes(conMemberInfo), listType);
                groupConList.stream().forEach(item->{
                    if ("0040".equals(item.getService_class_code())){
                        groupList.add(item.getSerial_number());
                    }
                });
            } catch (IOException e) {
                log.error("融合用户列表转换异常{}",e.getMessage());
            }
        }
        if (mainMemberInfo.size()>0){
            List<GroupInfo> groupMainList = new ArrayList();
            CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, GroupInfo.class);
            try {
                groupMainList = objectMapper.readValue(objectMapper.writeValueAsBytes(mainMemberInfo), listType);
                groupMainList.stream().forEach(item->{
                    if ("0040".equals(item.getService_class_code())){
                        groupList.add(item.getSerial_number());
                    }
                });
            } catch (IOException e) {
                log.error("主副卡用户列表转换异常{}",e.getMessage());
            }
        }
        return groupList;
    }
}
