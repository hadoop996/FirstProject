package com.example.H5;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 郝少杰
 * @date 2020/11/9 21:31
 */
public class mapToList {
    public static void main(String[] args) {
        Map provinceMap = new HashMap<>();
        provinceMap.put("内蒙古", "10");
        provinceMap.put("北京", "11");
        provinceMap.put("天津", "13");
        provinceMap.put("山东", "17");
        provinceMap.put("河北", "18");
        provinceMap.put("山西", "19");
        provinceMap.put("安徽", "30");
        provinceMap.put("上海", "31");
        provinceMap.put("江苏", "34");
        provinceMap.put("浙江", "36");
        provinceMap.put("福建", "38");
        provinceMap.put("海南", "50");
        provinceMap.put("广东", "51");
        provinceMap.put("广西", "59");
        provinceMap.put("香港", "61");
        provinceMap.put("青海", "70");
        provinceMap.put("湖北", "71");
        provinceMap.put("云南", "86");
        provinceMap.put("江西", "75");
        provinceMap.put("湖南", "74");
        provinceMap.put("河南", "76");
        provinceMap.put("贵州", "85");
        provinceMap.put("西藏", "79");
        provinceMap.put("四川", "81");
        provinceMap.put("重庆", "83");
        provinceMap.put("陕西", "84");
        provinceMap.put("甘肃", "87");
        provinceMap.put("宁夏", "88");
        provinceMap.put("新疆", "89");
        provinceMap.put("吉林", "90");
        provinceMap.put("辽宁", "91");
        provinceMap.put("黑龙江", "97");
        testKeySet(provinceMap);
        testValues(provinceMap);

    }

    public static void testKeySet(Map<String, String> map) {
        String a = "";
        int b = 0;
        for (String key : map.keySet()) {
            b++;
            a += "\"" + key + "\",";
        }
        System.out.println(b);
        System.out.println(a);
    }

    // values 获取value
    public static void testValues(Map<String, String> map) {
        String b = "";
        int a = 0;
        for (String value : map.values()) {
            a++;
            b += "\"" + value + "\",";
        }
        System.out.println(a);
        System.out.println(b);
    }
}
