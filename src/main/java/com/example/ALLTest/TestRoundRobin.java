package com.example.ALLTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class TestRoundRobin {

    // 1.定义map, key-ip,value-weight
    static Map<String,Integer> ipMap=new HashMap<>();
    static {
        ipMap.put("192.168.13.1",1);
        ipMap.put("192.168.13.2",1);
        ipMap.put("192.168.13.3",1);

    }
    AtomicLong SINK_COUNT = new AtomicLong(0);
    public synchronized String RoundRobin(){
        Map<String,Integer> ipServerMap=new ConcurrentHashMap<>();
        ipServerMap.putAll(ipMap);

        // 2.取出来key,放到set中
        Set<String> ipset=ipServerMap.keySet();

        // 3.set放到list，要循环list取出
        ArrayList<String> iplist=new ArrayList<String>();
        iplist.addAll(ipset);

        String serverName=null;

        // 4.定义一个循环的值，如果大于set就从0开始
        synchronized(SINK_COUNT){
            if (SINK_COUNT.get()>=ipset.size()){
                SINK_COUNT.set(0);
            }
            serverName=iplist.get((int) SINK_COUNT.get());
            //轮询+1
            SINK_COUNT.set(SINK_COUNT.get()+1);
        }
        return serverName;
    }

    public static void main(String[] args) {
        TestRoundRobin testRoundRobin=new TestRoundRobin();
        for (int i=0;i<10;i++){
            String serverIp=testRoundRobin.RoundRobin();
            System.out.println(serverIp);
        }
    }

}
