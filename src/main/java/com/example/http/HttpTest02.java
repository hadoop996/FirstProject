package com.example.http;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSONObject;
import com.ohaotian.plugin.base.exception.ZTBusinessException;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class HttpTest02 {
    public static void main(String[] args) {

        ExecutorService es = new ThreadPoolExecutor(100, 200, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        AtomicInteger atomicInteger = new AtomicInteger(1);
        String integrationUrl = "https://omotest.10010.com:30051/service/common/userManage/getUserInfo";

        String sysDataUrl = "http://127.0.0.1:8081/test/test01";
        for (int i=0;i<1000;i++){
            int number = atomicInteger.getAndAdd(1);
            final String j = String.valueOf(i);
            es.execute(new Runnable() {
                @Override
                public void run() {
                    JSONObject JsonObject = new JSONObject();
                    JsonObject.put("serialNumber", "047508708126");
                    JsonObject.put("netTypeCode", "40");
                    String json = JsonObject.toJSONString();
                    String rspJson = HttpRequest.post(integrationUrl)
                            .keepAlive(false)
                            .body(json)
                            .execute().body();
                    System.out.println(number);
//                    String rspJson = null;
//                    try {
//                        rspJson = HttpUtil.doPost(sysDataUrl, (status, res) -> {
//                            if (status == HttpStatus.SC_OK) {
//                                return res;
//                            } else {
//                                throw new ZTBusinessException("调用接口失败！");
//                            }
//                        }, new HashMap<>());
//                    } catch (Exception e) {
//                        System.err.println("失败"+e.getMessage());
//                    }
//                    System.out.println(rspJson + "---" + number);
                }
            });
        }
        es.shutdown();
        while (true) {
            if (es.isTerminated()) {
                System.out.println("所有的子线程都结束了！");
            }
            break;
        }

    }
}
