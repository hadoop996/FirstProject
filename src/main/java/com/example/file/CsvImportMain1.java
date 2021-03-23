package com.example.file;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.*;

public class CsvImportMain1 {
    public static void main(String[] args) throws Exception {
        List<String> engineer = getEngineer("C:\\Users\\10211\\Desktop\\无工程师.txt");
        export2SQL("C:\\Users\\10211\\Desktop\\北京工程师发展人编码对应关系.csv", "C:\\Users\\10211\\Desktop\\工程师有误11.txt", 1, engineer);
    }

    private static List<String> getEngineer(String inputFile) throws IOException {
        List list = new ArrayList();
        FileInputStream fins = new FileInputStream(inputFile);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fins));
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.equals("")) {
                continue;
            }
            list.add(line);
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
}
