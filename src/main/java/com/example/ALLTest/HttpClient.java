package com.example.ALLTest;


import com.example.utils.JsonUtils;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Map;

/**
 * @author 郝少杰
 * @date 2020/12/11 10:52
 */
public class HttpClient {

    public static void main(String[] args) {
        String url = "http://localhost:8082/api/navigation/getEparchyCount";
        String sendHttpPost = HttpClientUtil.getInstance().sendHttpPost(url);
        System.out.println(sendHttpPost);
    }

    @Test
    public void withParam(){
        String url = "http://localhost:8082/api/navigation/getBanner";
        Map<String,Double> map = Maps.newHashMap();
        map.put("lng",136.12);
        map.put("lat",39.12);
        String s = HttpClientUtil.getInstance().sendHttpPost(url, JsonUtils.toString(map));
        System.out.println(s);
    }

}
