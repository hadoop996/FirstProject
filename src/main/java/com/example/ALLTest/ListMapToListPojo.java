package com.example.ALLTest;

import com.example.domain.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.google.common.collect.Maps;
import org.assertj.core.util.Lists;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 郝少杰
 * @date 2021/1/4 18:30
 */
public class ListMapToListPojo {
    public static void main(String[] args) throws IOException {
        List list = Lists.newArrayList();
        for (int i=0;i<20;i++){
            Map map = Maps.newHashMap();
            map.put("name","hhhh"+i);
            map.put("age",i);
            list.add(map);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Person.class);
        System.out.println(listType);
        List<Person> rspList = objectMapper.readValue(objectMapper.writeValueAsBytes(list), listType);
        System.out.println(rspList);
//        Date d = new Date();
//        System.out.println(d);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
//        String dateNowStr = sdf.format(d);
//        System.out.println("格式化后的日期：" + dateNowStr);
    }
}
