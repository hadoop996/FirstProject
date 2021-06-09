package com.example.utils;


import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName:
 * @Description:
 * @Author: zhanglw92@chinaunicom.cn
 * @Data: 2019/8/7 11:03
 */
public class MapTool {
    static public Map<String,Object> Obj2Map(Object obj) throws Exception{
        Map<String,Object> map=new HashMap<String, Object>();
        Field[] fields = obj.getClass().getDeclaredFields();
        for(Field field:fields){
            field.setAccessible(true);
            if(field.getType() == String.class) {
                if(StringUtils.isNotBlank((String)field.get(obj))) {
                    map.put(HumpTool.humpToLine2(field.getName()), field.get(obj));
                }
                /*else {
                    map.put(HumpTool.humpToLine2(field.getName()), null);
                }*/
            }
            else if(field.getType() == List.class) {
                List<Object> srclist = (List)field.get(obj);
                List<Map<String,Object>> dstList = new ArrayList<>();
                if(srclist!=null) {
                    for (Object element : srclist) {
                        Map<String, Object> elementMap = Obj2Map(element);
                        dstList.add(elementMap);
                    }
                    map.put(HumpTool.humpToLine2(field.getName()), dstList);
                }
            }
            else if(field.getType() == Map.class) {
                map.put(HumpTool.humpToLine2(field.getName()), field.get(obj));
            }
            else {
                Map<String,Object> elementMap = Obj2Map(field.get(obj));
                map.put(HumpTool.humpToLine2(field.getName()), elementMap);
            }
        }
        return map;
    }

    static public Object map2Obj(Map<String,Object> map,Class<?> clz) throws Exception{
        if(map == null){
            return null;
        }
        Object obj = clz.newInstance();
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        for(Field field:declaredFields){
            int mod = field.getModifiers();
            if(Modifier.isStatic(mod) || Modifier.isFinal(mod)){
                continue;
            }
            String key = HumpTool.humpToLine2(field.getName());
            if(map.containsKey(key)) {
                if (field.getType() == List.class) {
                    // 如果是List类型，得到其Generic的类型
                    Type genericType = field.getGenericType();
                    // 如果是泛型参数的类型
                    if (genericType instanceof ParameterizedType) {
                        ParameterizedType pt = (ParameterizedType) genericType;
                        //得到泛型里的class类型对象
                        Class<?> innerListClazz = (Class<?>) pt.getActualTypeArguments()[0];
                        List list = new ArrayList();
                        if(map.get(key) instanceof Map){
                            Map<String, Object> innerMap = (Map<String, Object>) map.get(key);
                            Object innerListObject = map2Obj(innerMap, innerListClazz);
                            list.add(innerListObject);
                        }
                        else if(map.get(key) instanceof List){
                            List innerList = (List)map.get(key);
                            for(int i=0;i<innerList.size();i++){
                                Map<String, Object> innerMap = (Map<String, Object>) innerList.get(i);
                                Object innerListObject = map2Obj(innerMap, innerListClazz);
                                list.add(innerListObject);
                            }
                        }
                        field.setAccessible(true);
                        field.set(obj, list);
                    }
                } else if (field.getType() == String.class) {
                    field.setAccessible(true);
                    field.set(obj, map.get(key));
                } else {
                    if(map.get(key) instanceof Map) {
                        Map<String, Object> innerMap = (Map<String, Object>) map.get(key);
                        field.setAccessible(true);
                        field.set(obj, map2Obj(innerMap,field.getType()));
                    }
                }
            }
        }
        return obj;
    }
}

