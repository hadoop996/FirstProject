//package com.example.demo;
//
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.zookeeper.WatchedEvent;
//import org.apache.zookeeper.Watcher;
//import org.apache.zookeeper.Watcher.Event.EventType;
//import org.apache.zookeeper.ZooKeeper;
//import org.apache.zookeeper.data.Stat;
//
//public class ZooTest {
//    private String groupNode = "/esb";
//    private ZooKeeper zk;
//    private Stat stat = new Stat();
//
//    private volatile List<String> serverlist;
//
//    private String hosts = "127.0.0.1:2181";
//
//    public void connectZooKeeper() throws Exception {
//        zk = new ZooKeeper(hosts, 5000, new Watcher() {
//
//            @Override
//            public void process(WatchedEvent event) {
//                // 如果/servergroup 发生关于子节点变化事件，更新serverlist，并重新监听
//                if (event.getType() == EventType.NodeChildrenChanged && groupNode.equals(event.getPath())) {
//                    try {
//                        updateServerList();
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//        updateServerList();
//    }
//
//    // 更新serverlist
//    public void updateServerList() throws Exception {
//        List<String> newserverlist = new ArrayList<String>();
//        List<String> sublist = zk.getChildren(groupNode, true);
//        for (String subNode : sublist) {
//            byte[] data = zk.getData(groupNode + "/" + subNode, false, stat);
//            String a = new String(data, "utf-8");
//            newserverlist.add(a);
//        }
//        serverlist = newserverlist;
//        System.out.println("serverlist updated:" + serverlist);
//    }
//
//    /*
//     * client的工作逻辑编写在这个方法中
//     * 我们先不做任务处理，让client sleep
//     */
//
//    public void handle() throws Exception {
//        //这里的线程休眠是让eclipse一直处于运行状态，这样才能动态接收到服务端传来的信息
//        Thread.sleep(Long.MAX_VALUE);
//    }
//
//    public static void main(String[] args) throws Exception {
//
//        ZooTest client = new ZooTest();
//        client.connectZooKeeper();
//        client.handle();
//
//    }
//
//}