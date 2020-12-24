//package com.example.demo;
//
//import com.alibaba.fastjson.JSONObject;
//import com.example.config.ZookeeperClient;
//import org.apache.zookeeper.CreateMode;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//import java.util.Map;
//
//@RestController
//public class TestController {
//    @Resource
//    ZookeeperClient zookeeperClient;
//
//    @RequestMapping("/update")
//    public String update(@RequestBody Map map) throws Exception {
//        zookeeperClient.updateData((String) map.get("path"), (Map) map.get("data"), ZookeeperClient.NodeTypeEnum.LISTENERNODE);
//        return "true";
//    }
//
//    @RequestMapping("/get")
//    public String get(@RequestBody JSONObject jsonObject) throws Exception {
//        String data = zookeeperClient.getData(jsonObject.getString("UNI_BSS_BODY").substring(15, 22), ZookeeperClient.NodeTypeEnum.LISTENERNODE);
//        return data;
//    }
//
//    @RequestMapping("/create")
//    public String create(@RequestBody Map map) throws Exception {
//        zookeeperClient.setData((String) map.get("path"), (Map) map.get("data"), ZookeeperClient.NodeTypeEnum.LISTENERNODE, CreateMode.EPHEMERAL);
//        return "true";
//    }
//
//    @RequestMapping("/create1")
//    public String create1(@RequestBody Map map) throws Exception {
//        zookeeperClient.setData((String) map.get("path"), (Map) map.get("data"), ZookeeperClient.NodeTypeEnum.NODEINFO, CreateMode.EPHEMERAL);
//        return "true";
//    }
//
//    @RequestMapping("/delete")
//    public String delete(@RequestBody Map map) throws Exception {
//        zookeeperClient.deleteNode((String) map.get("path"), ZookeeperClient.NodeTypeEnum.LISTENERNODE);
//        return "true";
//    }
//
//    @Value("${test.public.url}")
//    static String a;
//
//    @Test
//    public void getA() {
//        System.out.println(a);
//    }
//}
