package com.example.file;

import java.io.*;
import java.util.*;

public class ningxia {
    public static void main(String[] args) throws Exception {
        List<String> engineer = getEngineer("D:\\C盘备份\\绑定关系整理\\山东\\山东绑定数据\\山东13295437.csv");
        fail("D:\\C盘备份\\绑定关系整理\\山东\\山东绑定数据\\工程师去重量.txt",engineer);
    }

    private static List<String> getEngineer(String inputFile) throws IOException {
        List list = new ArrayList();
        FileInputStream fins = new FileInputStream(inputFile);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fins));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] fields = line.split(",");
            if (fields.length != 7) {
                continue;
            }
            if (!list.contains(fields[4])){
                list.add(fields[4]);
            }
        }
        reader.close();
        return list;
    }

    public static void export2SQL(String inputFile, String outputFile, int skipRecords, List<String> engineer ) throws Exception {
        FileInputStream fins = new FileInputStream(inputFile);
        File outFile = new File(outputFile);
        outFile.createNewFile();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));
        BufferedReader reader = new BufferedReader(new InputStreamReader(fins));
        for (int i = 0; i < skipRecords; i++) {
            reader.readLine();
        }
        String line;
        String a = "(";
        while ((line = reader.readLine()) != null) {

            String[] fields = line.split(",");
            if (fields.length != 7) {
                continue;
            }
            String phone = fields[4].replaceAll("\"", "");
            if (phone.equals("")) {
                continue;
            }

            if (engineer.contains(phone)){
                a = a+"'"+phone+"',";
                writer.write(line+"\n");
            }
        }
        a = a+")";
        System.out.println(a);
        reader.close();
        writer.flush();
        writer.close();
    }

    public static void fail(String outputFile, List<String> failList) throws Exception {
        File outFile = new File(outputFile);
        outFile.createNewFile();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));
        for (String s : failList) {
            writer.write(s+"\n");
        }
        writer.flush();
        writer.close();
    }
}
