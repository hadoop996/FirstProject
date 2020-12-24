package com.example.demo;

import com.example.config.ZookeeperClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController

public class OnlineOfflineQueryController {
    @Resource
    ZookeeperClient zookeeperClient;

    public static Map<String, Object> returnMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("code", "0000");
        map.put("message", "成功");
        map.put("data", true);
        return map;
    }

    public static Map<String, Object> returnOffMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("code", "8888");
        map.put("message", "失败");
        map.put("data", false);
        return map;
    }

    @RequestMapping("/instanceOffline")
    public Map<String, Object> instanceOffline(@RequestBody Map map) throws Exception {
        zookeeperClient.updateDataAI((String) map.get("path"), (List<String>) map.get("instanceList"), ZookeeperClient.NodeTypeEnum.LISTENERNODE);
        return returnMap();
    }

    @RequestMapping("/appOnline")
    public Map<String, Object> instanceOnline(@RequestBody Map map) {
        try {
            zookeeperClient.updateDataAO((String) map.get("path"), ZookeeperClient.NodeTypeEnum.LISTENERNODE);
            return returnMap();
        } catch (Exception e) {
            return returnOffMap();
        }
    }

    /*@RequestMapping("/appOffline")
    public String appOffline(@RequestBody Map map) throws Exception {
        zookeeperClient.updateData((String) map.get("path"), (String) map.get("data"), ZookeeperClient.NodeTypeEnum.LISTENERNODE);
        return "true";
    }*/

    /*@RequestMapping("/appOnline")
    public String appOnline(@RequestBody Map map) throws Exception {
        zookeeperClient.updateData((String) map.get("path"), (String) map.get("data"), ZookeeperClient.NodeTypeEnum.LISTENERNODE);
        return "true";
    }*/

    @RequestMapping("/queryList")
    public String get(@RequestBody Map map) throws Exception {
        String data = zookeeperClient.getData((String) map.get("path"), ZookeeperClient.NodeTypeEnum.LISTENERNODE);
        return data;
    }
}
