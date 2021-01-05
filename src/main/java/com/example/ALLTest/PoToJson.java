package com.example.ALLTest;

import com.example.domain.Person;
import com.example.utils.JsonUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 郝少杰
 * @date 2021/1/4 18:30
 */
public class PoToJson {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("!23");
        System.out.println(JsonUtils.toString(person));
        Map<String, Object> rspMap = new HashMap<>();
        rspMap.put("aaa",JsonUtils.toString(person));
        System.out.println(rspMap);
        System.out.println("123");
//        Date d = new Date();
//        System.out.println(d);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
//        String dateNowStr = sdf.format(d);
//        System.out.println("格式化后的日期：" + dateNowStr);
    }
}
