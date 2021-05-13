package com.example.ALLTest;

import com.example.xml.pojo.Person;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class SystemTest {
    public static void main(String[] args) {
//        String configPath = System.getProperty("config.path");
//        System.out.println(configPath);
//
//        String localFilePath = System.getProperty("user.dir");
//        System.out.println(localFilePath);

        List<String> list = new ArrayList<>();
        list.add(4,"121221");
//        list.add(null);
        System.out.println(list);
    }
}
