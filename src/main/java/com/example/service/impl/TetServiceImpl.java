package com.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.domain.UserEngineerPO;
import com.example.mapper.TestMapper;
import com.example.service.TetService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
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
//        export2SQL("C:\\Users\\10211\\Desktop\\河南-山西\\t_henan.sql",1);
        Set<String> listCount = new HashSet<>();
        Set<String> listEngineer = new HashSet<>();
        Set<String> errEngineer = new HashSet<>();
        Set<String> engineerPhone = new HashSet<>();
        List<String> engineerNullList = new ArrayList<String>();
        List<String> failList = new ArrayList<String>();
        Map<String, String> beijing = beijing("C:\\Users\\10211\\Desktop\\北京数据\\北京.csv", 1);
//        for (int i =1 ;i<=7 ;i++){
             exportBeijing("C:\\Users\\10211\\Desktop\\北京数据\\北京7.txt",1,
                     listCount,beijing,listEngineer,
                     engineerNullList,errEngineer,failList,engineerPhone);
//        }
        engineerNul("C:\\Users\\10211\\Desktop\\北京数据\\第四批\\工程师不存在.txt",errEngineer);

        fail("C:\\Users\\10211\\Desktop\\北京数据\\第四批\\第四批失败明细(工程师数据不存在或有误).txt",failList);

        engineerPhone("C:\\Users\\10211\\Desktop\\北京数据\\第四批\\提供工程师手机号.txt",engineerPhone);
        log.error("总数据量{}",total);
        log.error("工程师总量{}",listEngineer.size());
        log.error("宽带账号总量{}",listCount.size());
        log.error("宽带账号重复{}",broadband);
        log.error("工程师为空{}",engineerPhoneNull);
        log.error("宽带账号为空{}",broadbandPhoneNull);
        log.error("工程师不存在{}",engineerNull);
        log.error("长度缺失{}",length);
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
                              List<String> failList,Set<String> engineerPhone) throws Exception {
        FileInputStream fins = new FileInputStream(inputFile);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fins));

        String line;
        long size = 1;
        List<UserEngineerPO> userEngineerPOS = new ArrayList<>(10000);
        List<UserEngineerPO> fail = new ArrayList<>(10000);
        int y =0;
        while ((line = reader.readLine()) != null) {
            String[] fields = line.split("\\|");
            if (fields==null) {
                failList.add(line+"\\|数据为空");
                continue;
            }
            if (listCount.contains(fields[1])){
                failList.add(line+"\\|宽带账号重复");
                broadband++;
                continue;
            }
            if (fields[0].equals("")){
                failList.add(line+"\\|手机号为空");
                engineerPhoneNull++;
                continue;
            }
            if (fields[1].equals("")){
                failList.add(line+"\\|宽带账号为空");
                broadbandPhoneNull++;
                continue;
            }
            if (fields.length!=2){
                failList.add(line+"\\|数据格式不正确");
                length++;
                continue;
            }

            if (!engineerPhone.contains(fields[0])){
                engineerPhone.add(fields[0]);
            }
            listEngineer.add(fields[0]);
            listCount.add(fields[1]);
            if (!StringUtils.isBlank(beijing.get(fields[0]))){
                userEngineerPOS.add(new UserEngineerPO(fields[0],fields[1]));
            }else{
                if (!errEngineer.contains(fields[0])){
                    errEngineer.add(fields[0]);
                }
                failList.add(line+"\\|工程师不存在");
                engineerNull++;
            }
//            if (userEngineerPOS.size()==10000){
//                testDao.insertUserList(userEngineerPOS);
//                total = total + userEngineerPOS.size();
//                userEngineerPOS = new ArrayList<>(10000);
//                log.info("第{}次执行，总数据量{}",size,total);
//                size++;
//            }
        }
        log.info("工程师手机号不村咋{}",y);
//        if(!userEngineerPOS.isEmpty()){
//            total = total + userEngineerPOS.size();
//            testDao.insertUserList(userEngineerPOS);
//            log.info("最后一次插入，第{}次执行，总数据量{}",size,total);
//        }
        reader.close();
    }

    @Override
    public void asyn1() throws InterruptedException {
        Thread.sleep(100000);
    }

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

}
