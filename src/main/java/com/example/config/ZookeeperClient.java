//package com.example.config;
//
//import com.example.utils.JsonUtils;
//import lombok.extern.slf4j.Slf4j;
//import net.sf.json.JSONObject;
//import org.apache.curator.framework.CuratorFramework;
//import org.apache.zookeeper.CreateMode;
//import org.apache.zookeeper.data.Stat;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * @ClassName: ZookeeperClient
// * @Description: zk客户端
// * @Date: 2019/3/28 10:45
// * @Author fuchangmin
// */
//@Slf4j
//@Component
//public class ZookeeperClient {
//
//
//    /**
//     * 节点类型
//     */
//    public enum NodeTypeEnum {
//        /**
//         * nodeInfo
//         */
//        NODEINFO,
//        /**
//         * listenerNode
//         */
//        LISTENERNODE
//    }
//
//    @Resource
//    private RegistryCenterProperties registryCenterProperties;
//
//
//    @Resource
//    private CuratorFramework zkClient;
//
//    /**
//     * 获取节点信息
//     *
//     * @param nodeName
//     * @param nodeTypeEnum
//     */
//    public String getData(String nodeName, NodeTypeEnum nodeTypeEnum) throws Exception {
//        switch (nodeTypeEnum) {
//            case NODEINFO:
//                return new String(getNodeData(registryCenterProperties.getNodeInfo() + "/" + nodeName), "UTF-8");
//            case LISTENERNODE:
//                return new String(getNodeData(registryCenterProperties.getListenerNode() + "/" + nodeName), "UTF-8");
//            default:
//                throw new IllegalArgumentException("the nodeTypeEnum can not null");
//        }
//    }
//
//
//    /**
//     * 创建zk 节点,并设置数据
//     *
//     * @param nodeName
//     * @param nodeData
//     * @param nodeTypeEnum
//     * @throws Exception
//     */
//    public void setData(String nodeName, Map nodeData, NodeTypeEnum nodeTypeEnum, CreateMode mode) throws Exception {
//        switch (nodeTypeEnum) {
//            case NODEINFO:
//                createNode(registryCenterProperties.getNodeInfo() + "/" + nodeName, JsonUtils.toString(nodeData), mode);
//                log.info("nodeName:" + registryCenterProperties.getNodeInfo() + "/" + nodeName + "nodeData:" + nodeData + "mode:" + mode);
//                break;
//            case LISTENERNODE:
//                createNode(registryCenterProperties.getListenerNode() + "/" + nodeName, JsonUtils.toString(nodeData), mode);
//                log.info("nodeName:" + registryCenterProperties.getListenerNode() + "/" + nodeName + "nodeData:" + nodeData + "mode:" + mode);
//                break;
//            default:
//                throw new IllegalArgumentException("the nodeTypeEnum can not null");
//        }
//    }
//
//    /**
//     * 更新节点数据
//     *
//     * @param nodeName
//     * @param nodeData
//     * @param nodeTypeEnum
//     * @throws Exception
//     */
//    public void updateData(String nodeName, Map nodeData, NodeTypeEnum nodeTypeEnum) {
//        switch (nodeTypeEnum) {
//            case NODEINFO:
//                updateNode(registryCenterProperties.getNodeInfo() + "/" + nodeName, JsonUtils.toString(nodeData));
//                break;
//            case LISTENERNODE:
//                updateNode(registryCenterProperties.getListenerNode() + "/" + nodeName, JsonUtils.toString(nodeData));
//                break;
//            default:
//                throw new IllegalArgumentException("the nodeTypeEnum can not null");
//        }
//    }
//
//    /**
//     * 更新节点数据
//     *
//     * @param list
//     * @param nodeTypeEnum
//     * @throws Exception
//     */
//    public void updateDataAI(String nodeName, List<String> list, NodeTypeEnum nodeTypeEnum) throws Exception {
//        Map<String, Object> map = new HashMap<>();
//        map.put("operType", 4);
//        map.put("instanceList", list);
//        JSONObject jsonMap = JSONObject.fromObject(map);
//        switch (nodeTypeEnum) {
//            case NODEINFO:
//                updateNode(registryCenterProperties.getNodeInfo() + "/" + nodeName, jsonMap.toString());
//                break;
//            case LISTENERNODE:
//                updateNode(registryCenterProperties.getListenerNode() + "/" + nodeName, jsonMap.toString());
//                break;
//            default:
//                throw new IllegalArgumentException("the nodeTypeEnum can not null");
//        }
//    }
//
//    public void updateDataAO(String nodeName, NodeTypeEnum nodeTypeEnum) throws Exception {
//        //HashMap hashMap = JSON.parseObject(new String(getNodeData(registryCenterProperties.getListenerNode() + "/" + nodeName),"UTF-8"), HashMap.class);
//       /* for (Object key : hashMap.keySet()) {
//            System.out.println("key= "+ key + " and value= " + hashMap.get(key));
//        }*/
//        Map<String, Object> map = new HashMap<>();
//        /*map.put("operType",2);
//        map.put("instanceList",list);
//        switch (nodeTypeEnum) {
//            case NODEINFO:
//                updateNode(registryCenterProperties.getNodeInfo() + "/" + nodeName, map);
//                break;
//            case LISTENERNODE:
//                updateNode(registryCenterProperties.getListenerNode() + "/" + nodeName, map);
//                break;
//            default:
//                throw new IllegalArgumentException("the nodeTypeEnum can not null");
//        }*/
//    }
//
//    /**
//     * 删除节点数据
//     *
//     * @param nodeName
//     * @param nodeTypeEnum
//     * @throws Exception
//     */
//    public void deleteNode(String nodeName, NodeTypeEnum nodeTypeEnum) throws Exception {
//        switch (nodeTypeEnum) {
//            case NODEINFO:
//                deleteNode(registryCenterProperties.getNodeInfo() + "/" + nodeName);
//                break;
//            case LISTENERNODE:
//                deleteNode(registryCenterProperties.getListenerNode() + "/" + nodeName);
//                break;
//            default:
//                throw new IllegalArgumentException("the nodeTypeEnum can not null");
//        }
//    }
//
//    /**
//     * 创建节点
//     *
//     * @param node
//     * @param nodeData
//     */
//    public void createNode(String node, String nodeData, CreateMode mode) throws Exception {
////        try {
////            Stat stat = zkClient.checkExists().forPath(node);
////            if(stat == null){
////                zkClient.create()
////                        .creatingParentContainersIfNeeded().withMode(mode)
////                        .forPath(node, nodeData.getBytes());
////            }
////        } catch (Exception e) {
////            log.error("ZookeeperClient.createNode ==> node: {}, nodeData: {} "+node+" "+nodeData, e);
////        }
//        zkClient.create()
//                .creatingParentContainersIfNeeded().withMode(mode)
//                .forPath(node, nodeData.getBytes("UTF-8"));
//        System.out.println("");
//    }
//
//    /**
//     * 更新节点
//     *
//     * @param node
//     * @param nodeData
//     */
//    private void updateNode(String node, String nodeData) {
//        try {
//            zkClient.setData().forPath(node, nodeData.getBytes("UTF-8"));
//        } catch (Exception e) {
//            log.error("ZookeeperClient.updateNode ==> node: {}, nodeData: { }" + node + " " + nodeData, e);
//        }
//    }
//
//    private void updateNode1(String node, Map nodeData) {
//        try {
//            zkClient.setData().forPath(node, nodeData.toString().getBytes("UTF-8"));
//        } catch (Exception e) {
//            log.error("ZookeeperClient.updateNode ==> node: {}, nodeData: { }" + node + " " + nodeData, e);
//        }
//    }
//
//    private void updateNodeAI(String node, List<String> nodeData) {
//        try {
//            zkClient.setData().forPath(node, nodeData.toString().getBytes("UTF-8"));
//        } catch (Exception e) {
//            log.error("ZookeeperClient.updateNode ==> node: {}, nodeData: { }" + node + " " + nodeData, e);
//        }
//    }
//
//    /**
//     * 删除节点
//     *
//     * @param node
//     */
//    private void deleteNode(String node) throws Exception {
//        zkClient.delete().forPath(node);
//
//    }
//
//    /**
//     * 获取节点信息
//     *
//     * @param node
//     * @return
//     */
//    private byte[] getNodeData(String node) throws Exception {
//        return zkClient.getData().forPath(node);
//    }
//
//    /**
//     * 创建节点
//     *
//     * @param node
//     * @param nodeData
//     */
//    public void createNodeIfNull(String node, String nodeData, CreateMode mode) throws Exception {
//        try {
//            Stat stat = zkClient.checkExists().forPath(node);
//            if (stat == null) {
//                zkClient.create()
//                        .creatingParentContainersIfNeeded().withMode(mode)
//                        .forPath(node, nodeData.getBytes("UTF-8"));
//                log.info("创建节点:" + node);
//            } else {
//                log.info("已经存在此节点:" + node);
//            }
//        } catch (Exception e) {
//            log.error("ZookeeperClient.createNode ==> node: {}, nodeData: {} " + node + " " + nodeData, e);
//        }
//    }
//
//}
