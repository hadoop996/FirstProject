package com.example.service.impl;

import com.example.domain.BroadBandInfo;
import com.example.domain.UserEngineerPO;
import com.example.mapper.TestMapper;
import com.example.service.TetService;
import com.example.utils.FileViewer;
import com.example.xml.pojo.Channl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.*;
import java.util.*;

/**
 * @author 郝少杰
 * @date 2021/2/10 11:57
 */
@Slf4j
@Service
public class TetServiceImpl implements TetService{

    @Resource
    TestMapper testDao;

    @Autowired
    AsyncTask async;

    int broadband = 0;
    int total = 0;
    int engineerPhoneNull = 0;
    int broadbandPhoneNull = 0;
    int engineerNull = 0;
    int length = 0;

    @Override
    public void getSql() throws Exception {
        Set<String> listCount = new HashSet<>();
        Set<String> listEngineer = new HashSet<>();
        Set<String> errEngineer = new HashSet<>();
        Set<String> engineerPhone = new HashSet<>();
        List<String> engineerNullList = new ArrayList<String>();
        List<String> failList = new ArrayList<String>();
        List<String> engineerList = new ArrayList<>();
        List<String> dangyuan = new ArrayList<>();
        Map<String,String> userBroadBandList = getUserBroadBand();
        List<String> hebeiList = getHebeiList();
        Map<String, String> beijing = beijing("D:\\绑定关系\\绑定关系整理\\新绑定关系\\新河北\\河北\\河北.csv", 1);
//        int i = 1;
        for (int i = 0;i<hebeiList.size();i++){
            exportBeijing(hebeiList.get(i),1,
                 listCount,beijing,listEngineer,
                 engineerNullList,errEngineer,failList,engineerPhone,engineerList,dangyuan,userBroadBandList);
//         i++;
        }
        engineerNul("D:\\绑定关系\\绑定关系整理\\新绑定关系\\新河北\\河北\\失败工程师不存在.txt",errEngineer);

        fail("D:\\绑定关系\\绑定关系整理\\新绑定关系\\新河北\\河北\\工程师不存在导致不入库.txt",failList);

        engineerPhone("D:\\绑定关系\\绑定关系整理\\新绑定关系\\新河北\\河北\\失败工程师手机号.txt",engineerPhone);

        log.info("总数据量{}",total);
        log.info("工程师总量{}",listEngineer.size());
        log.info("宽带账号总量{}",listCount.size());
        log.info("宽带账号重复{}",broadband);
        log.info("工程师为空{}",engineerPhoneNull);
        log.info("宽带账号为空{}",broadbandPhoneNull);
        log.info("工程师不存在{}",engineerNull);
        log.info("长度缺失{}",length);
    }

    private List<String> getHebeiList() {
        return FileViewer.getListFiles("D:\\绑定关系\\绑定关系整理\\新绑定关系\\新河北\\河北\\csv", "csv", false);
    }

    public void export2SQL(String inputFile, int skipRecords) throws Exception {
        List<String> list = new ArrayList<>(10000);
        FileInputStream fins = new FileInputStream(inputFile);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fins));
        for (int i = 0; i < skipRecords; i++) {
            reader.readLine();
        }
        int size = 1;
        int total = 0;
        String line;
        while ((line = reader.readLine()) != null) {
            String value = line.substring(line.indexOf("values")+6,line.length()-1);
            list.add(value);
            if (list.size()==10000){
                testDao.insertEngineerUserList(list);
                total = total + list.size();
                list = new ArrayList<>(10000);
                log.info("第{}次执行，总数据量{}",size,total);
                size++;
            }
        }
        if(!list.isEmpty()){
            total = total + list.size();
            testDao.insertEngineerUserList(list);
            log.info("最后一次插入，第{}次执行，总数据量{}",size,total);
        }
        reader.close();
    }

    public void exportBeijing(String inputFile, int skipRecords,Set<String> listCount,Map<String, String> beijing,
                              Set<String> listEngineer,List<String> engineerNullList,Set<String> errEngineer,
                              List<String> failList,Set<String> engineerPhone,List<String> engineerList,
                              List<String> dangyuan,Map<String,String> userBroadBandList) throws Exception {
//        Map<String, String> map = getMap();
        FileInputStream fins = new FileInputStream(inputFile);
//        BufferedReader reader = new BufferedReader(new InputStreamReader(fins,"GBK"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(fins));
        List<BroadBandInfo> checkBroadBandList = new ArrayList();
        Boolean flag = true;
        String line;
        long size = 1;
        List<UserEngineerPO> userEngineerPOS = new ArrayList<>(10000);
        List<UserEngineerPO> fail = new ArrayList<>(10000);
        int y = 0;
        while ((line = reader.readLine()) != null) {
            String[] fields = line.split("\\,");
            if (fields == null) {
                failList.add(line + ",数据为空");
                continue;
            }
            if (fields.length!=10){
                failList.add(line+",数据格式不正确");
                continue;
            }

            if (fields[4].equals("")) {
                failList.add(line + ",手机号为空");
                engineerPhoneNull++;
                continue;
            }
            if (fields[7].equals("")) {
                failList.add(line + ",宽带编码为空");
                engineerPhoneNull++;
                continue;
            }

            if (!StringUtils.isEmpty(userBroadBandList.get(fields[7]))){
                continue;
            }

            if (listCount.contains(fields[7])) {
                failList.add(line + ",宽带账号重复");
                checkBroadBandList.add(new BroadBandInfo(fields[4], fields[7], "宽带账号重复", "51"));
                broadband++;
                continue;
            }
//            if (!StringUtils.isBlank(map.get(fields[7]))){
//                continue;
//            }
            if (!engineerPhone.contains(fields[4])) {
                engineerPhone.add(fields[4]);
            }
            listEngineer.add(fields[4]);
            listCount.add(fields[7]);
            if (!StringUtils.isBlank(beijing.get(fields[4]))) {
                userEngineerPOS.add(new UserEngineerPO(fields[4], fields[7].replace("\'", "")));
            } else {
                if (!errEngineer.contains(fields[4])) {
                    errEngineer.add(fields[4]);
                }
                failList.add(line+ ",工程师不存在");
                engineerNull++;
                continue;
            }
            if (userEngineerPOS.size() == 10000) {
//                if (i <7) {
//                    testDao.insertUserList(userEngineerPOS);
//                    total = total + userEngineerPOS.size();
//                    userEngineerPOS = new ArrayList<>(10000);
//                    log.info("第{}次执行，总数据量{}", size, total);
//                    size++;
//                } else {
                    testDao.insertUserList2(userEngineerPOS);
                    total = total + userEngineerPOS.size();
                    userEngineerPOS = new ArrayList<>(10000);
                    log.info("第{}次执行，总数据量{}", size, total);
                    size++;
//                }
//                }
            }
//            if (checkBroadBandList.size() == 100) {
//                testDao.insertUserBroadBandList(checkBroadBandList);
//            }
        }
        if (!userEngineerPOS.isEmpty()) {
            total = total + userEngineerPOS.size();
            testDao.insertUserList2(userEngineerPOS);
            log.info("最后一次插入，第{}次执行，总数据量{}", size, total);
        }

        reader.close();
    }

    @Override
    public void asyn1() throws InterruptedException {
        Thread.sleep(100000);
    }
//
//    @Override
//    public void channl() throws Exception {
//        Channl Channl = new Channl();
//        Channl.setAge("12312");
//        Channl.setName("341231");
//        log.info(Channl.toString());
//    }

    public Map<String,String> beijing(String inputFile, int skipRecords) throws Exception {
        Map<String,String> map = new HashMap<>();
        FileInputStream fins = new FileInputStream(inputFile);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fins));
        String line;
        long size = 0;
        HashSet<String> brandbondSet = new HashSet<>();
        while ((line = reader.readLine()) != null) {
            if (line==null||line.equals("")||brandbondSet.contains(line)) {
                continue;
            }
            brandbondSet.add(line);
            map.put(line,"1");
            ++size;
        }
        reader.close();
        return map;
    }


    public void engineerNul(String outputFile,Set<String> engineerNullList) throws Exception {
        File outFile = new File(outputFile);
        outFile.createNewFile();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));
        HashSet<String> brandbondSet = new HashSet<>();
        int size = 0;
        for (String s : engineerNullList) {
            writer.write(s+"\n");
            size++;
        }
        log.error("工程师不存在{}",size);
        writer.flush();
        writer.close();
    }

    public void fail(String outputFile,List<String> failList) throws Exception {
        File outFile = new File(outputFile);
        outFile.createNewFile();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));
        HashSet<String> brandbondSet = new HashSet<>();
        int size = 0;
        for (String s : failList) {
            writer.write(s+"\n");
        }
        writer.flush();
        writer.close();
    }

    public void engineerPhone(String outputFile,Set<String> failList) throws Exception {
        File outFile = new File(outputFile);
        outFile.createNewFile();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));
        HashSet<String> brandbondSet = new HashSet<>();
        int size = 0;
        for (String s : failList) {
            writer.write(s+"\n");
        }
        writer.flush();
        writer.close();
    }

    public void dangyuan(String outputFile,List<String> failList) throws Exception {
        File outFile = new File(outputFile);
        outFile.createNewFile();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));
        HashSet<String> brandbondSet = new HashSet<>();
        int size = 0;
        for (String s : failList) {
            writer.write(s+"\n");
        }
        writer.flush();
        writer.close();
    }

    public Map<String,String> getMap(){
        List<String> engineerList = testDao.getEngineerMap();
        if(!engineerList.isEmpty()){
            Map<String,String> engineerMap = new HashMap<String,String>(engineerList.size());
            for (String str : engineerList) {
                engineerMap.put(str,"1");
            }
            return engineerMap;
        }else {
            return null;
        }
    }

    public Map<String,String> getUserBroadBand(){
        List<String> userList = new ArrayList<>();
        Map<String,String> map = new HashMap();
        testDao.getUserBroadBand(new ResultHandler<String>() {
            @Override
            public void handleResult(ResultContext<? extends String> resultContext) {
                userList.add(resultContext.getResultObject());
            }
        });
        for (String s : userList) {
            map.put(s,"1");
        }
        return map;
    }
}
