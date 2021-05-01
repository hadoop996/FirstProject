package com.example.file;

import java.io.*;
import java.util.HashSet;

/**
 * @author 郝少杰
 * @date 2021/4/22 17:27
 */
public class ReadTest {
    public static void main(String[] args) throws IOException {
        getRead("C:\\Users\\10211\\Desktop\\新建文本文档.txt");
    }
    public static void getRead(String inputFile) throws IOException {
        FileInputStream fins = new FileInputStream(inputFile);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fins));
        String line;
        String sql = "delete from t_user_engineer_rel where user_broadcast in ('";
        while ((line = reader.readLine()) != null) {
            sql+=line + "','";
        }
        sql = sql.substring(0,sql.length()-2);
        sql = sql + ")";
        System.out.println(sql);
        reader.close();
    }
}
