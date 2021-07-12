package com.example.rocketmq;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.PosixParser;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.protocol.body.ClusterInfo;
import org.apache.rocketmq.common.protocol.route.BrokerData;
import org.apache.rocketmq.remoting.exception.RemotingConnectException;
import org.apache.rocketmq.remoting.exception.RemotingSendRequestException;
import org.apache.rocketmq.remoting.exception.RemotingTimeoutException;
import org.apache.rocketmq.srvutil.ServerUtil;
import org.apache.rocketmq.tools.admin.DefaultMQAdminExt;
import org.apache.rocketmq.tools.command.SubCommandException;
import org.apache.rocketmq.tools.command.topic.UpdateTopicSubCommand;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RocketMQUtil {
    /**
     * 创建topic 可以自定义所有topic支持的参数
     * @param subargs updateTopic命名支持的所有参数选项
     * @return topic创建成功，返回 true
     * @throws SubCommandException
     */
    public static boolean createTopic(String[] subargs) throws SubCommandException {
        /*String[] subargs = new String[] {
                "-b 10.1.4.231:10911",
                "-t unit-test-from-java-1",
                "-r 8",
                "-w 8",
                "-p 6",
                "-o false",
                "-u false",
                "-s false"};*/
        UpdateTopicSubCommand cmd = new UpdateTopicSubCommand();
        Options options = ServerUtil.buildCommandlineOptions(new Options());
        final Options updateTopicOptions = cmd.buildCommandlineOptions(options);
        final CommandLine commandLine = ServerUtil
                .parseCmdLine(cmd.commandName(),
                        subargs, updateTopicOptions, new PosixParser());

        cmd.execute(commandLine, updateTopicOptions, null);
        return true;
    }

    /**
     * 根据 brokerAddr or clusterName 创建topic
     * @param brokerAddr  在指定 broker 上创建topic时，此参数为必填，否则传null
     * @param clusterName 在指定 cluster 上创建topic时，此参数为必填，否则传null
     * @param topic       要创建的topic
     * @return            创建成功，返回true
     */
    public static boolean createTopic(String brokerAddr, String clusterName, String topic) throws Exception {
        if (StringUtils.isBlank(topic)) {
            return false;
        }
        List<String> argList = new LinkedList<>();
        argList.add(topic);
        if (StringUtils.isNotBlank(brokerAddr)) {
            argList.add(brokerAddr.trim());
        } else {
            argList.add(clusterName.trim());
        }
        return createTopic(argList.toArray(new String [0]));
    }

    /**
     * 在指定name server下使用默认参数创建topic
     * @param namesrvAddr
     * @param topic
     * @return
     */
    public static boolean createTopic(String namesrvAddr, String topic) {
        try {
            Set<String> clusterNames = RocketMQUtil.getClusterNames(namesrvAddr);
            for (String clusterName : clusterNames) {
                RocketMQUtil.createTopic(null, clusterName, topic);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * 获取指定 namesrv下的集群信息
     * @param namesrvAddr
     * @return
     * @throws MQClientException
     * @throws InterruptedException
     * @throws MQBrokerException
     * @throws RemotingTimeoutException
     * @throws RemotingSendRequestException
     * @throws RemotingConnectException
     */
    public static ClusterInfo getClusterInfo(String namesrvAddr) throws MQClientException, InterruptedException, MQBrokerException, RemotingTimeoutException, RemotingSendRequestException, RemotingConnectException {
        if (StringUtils.isBlank(namesrvAddr)) {
            return new ClusterInfo();
        }
        DefaultMQAdminExt mqAdminExt = new DefaultMQAdminExt(5000L);
        mqAdminExt.setInstanceName(Long.toString(System.currentTimeMillis()));
        mqAdminExt.setNamesrvAddr(namesrvAddr);
        mqAdminExt.start();

        ClusterInfo clusterInfo = mqAdminExt.examineBrokerClusterInfo();
        mqAdminExt.shutdown();
        return clusterInfo;
    }

    /**
     * 获取指定name server下的所有集群名称
     * @param namesrvAddr
     * @return
     * @throws MQClientException
     * @throws InterruptedException
     * @throws MQBrokerException
     * @throws RemotingTimeoutException
     * @throws RemotingSendRequestException
     * @throws RemotingConnectException
     */
    public static Set<String> getClusterNames(String namesrvAddr) throws MQClientException, InterruptedException, MQBrokerException, RemotingTimeoutException, RemotingSendRequestException, RemotingConnectException {
        return getClusterInfo(namesrvAddr).getClusterAddrTable().keySet();
    }

    /**
     * 获取指定 namesrv 下的所有broker信息（多name server下不确定能否正常工作）
     * @param namesrvAddr namesrv地址
     * @return HashMap<String, BrokerData>
     */
    public static Map<String, BrokerData> getAllBrokerInfo(String namesrvAddr) throws MQClientException, InterruptedException, MQBrokerException, RemotingTimeoutException, RemotingSendRequestException, RemotingConnectException {
        return getClusterInfo(namesrvAddr).getBrokerAddrTable();
    }

    /**
     * 获取连接到指定 namesrv 下的所有broker地址
     * @param namesrvAddr
     * @return
     */
    public static Set<String> getBrokerAddrs(String namesrvAddr) throws InterruptedException, RemotingConnectException, RemotingSendRequestException, RemotingTimeoutException, MQClientException, MQBrokerException {
        Map<String, BrokerData> allBrokerInfo = getAllBrokerInfo(namesrvAddr);
        Set<String> brokerAddrs = new HashSet<>();
        for (BrokerData brokerData : allBrokerInfo.values()) {
            brokerAddrs.addAll(brokerData.getBrokerAddrs().values());
        }
        return brokerAddrs;
    }
}
