package com.example.work;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class InDemo {
    public static void main(String[] args) throws Exception {
        export2SQL("C:\\Users\\29256\\Desktop\\河南绑定明细\\上传.csv");
    }

    public static void export2SQL(String inputFile) throws Exception {
        FileInputStream fins = new FileInputStream(inputFile);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fins));
        for (int i = 0; i < 1; i++) {
            reader.readLine();
        }
        List list = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            list.add("'"+line+"'");
        }
        System.out.println("");
        reader.close();
    }
}
