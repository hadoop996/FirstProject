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
        String url = "http://localhost:8080//canal/manage/app/offline";
        String sendHttpPost = HttpClientUtil.getInstance().sendHttpPost(url);
        System.out.println(sendHttpPost);
    }

    @Test
    public void withParam(){
        String url ="http://localhost:8080/canal/manage/a";
        Map<String,String> map = Maps.newHashMap();
        map.put("token","a");
        map.put("client_ip","b");
        map.put("user_id","cb");
        map.put("enc_flag","b");
        map.put("login_valid","b");
        String s = HttpClientUtil.getInstance().sendHttpPost(url, map);
        System.out.println(s);
    }

}
