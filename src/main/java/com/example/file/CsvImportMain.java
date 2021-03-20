package com.example.file;

import java.io.*;
import java.util.HashSet;

public class CsvImportMain {
    public static void main(String[] args) throws Exception {
        export2SQL("C:\\Users\\29256\\Desktop\\河南绑定明细\\上传.csv", "d:/t_henan.sql", 1, null);
    }

    public static void export2SQL(String inputFile, String outputFile, int skipRecords, String sql, int ... columns) throws Exception {
        FileInputStream fins = new FileInputStream(inputFile);
        File outFile = new File(outputFile);
        outFile.createNewFile();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));
        BufferedReader reader = new BufferedReader(new InputStreamReader(fins));
        for (int i = 0; i < skipRecords; i++) {
            reader.readLine();
        }
        String line;
        long size = 0;
        HashSet<String> brandbondSet = new HashSet<>();
        while ((line = reader.readLine()) != null) {
            String[] fields = line.split(",");
            if (fields.length != 10) {
                continue;
            }
            String phone = fields[8].replaceAll("\"", "");
            String brandbond = fields[9].replaceAll("\"", "");
            if (phone.equals("") || brandbond.equals("") || brandbondSet.contains(brandbond)) {
                continue;
            }
            brandbondSet.add(brandbond);
            writer.write("insert t_henan(engineer_phone, brandbond_code) values('" + phone + "','" + brandbond + "');\n");
            ++size;
        }
        System.out.println("Records:" + size);
        reader.close();
        writer.flush();
        writer.close();
    }
}
