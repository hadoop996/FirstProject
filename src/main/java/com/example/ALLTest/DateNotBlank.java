package com.example.ALLTest;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DateNotBlank {
    private final static  String FILE_NAME_PRFIX = "C_B_";
    private final static String FILE_NAME_SUFFIX = ".gz";

    public static void main(String[] args) {
//        DateTime start = DateUtil.beginOfDay(DateUtil.yesterday());
//        DateTime end = DateUtil.offsetDay(start, 1);
//        System.out.println("123");
        decompressingFiles();
        String fileName = "C_B_83_BSDM_CHL_20210515_0001_A_1.XML.gz";
        if (fileName.contains(FILE_NAME_PRFIX) && fileName.contains("CHL") && !fileName.contains(FILE_NAME_SUFFIX)) {
            System.out.println("符合文件格式");
        }else {
            System.out.println("文件格式错误");
        }
    }

    public static void decompressingFiles() {
        List<File> sourceFile = new ArrayList();
        String fileName = "C_B_70_BSDM_CHL_20210515_0001_A_1.XML.gz";
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        if (".gz".equals(fileType)) {
            fileName = fileName.substring(0, fileName.lastIndexOf("."));
            String fileType2 = fileName.substring(fileName.lastIndexOf("."));
            if (".tar".equals(fileType2)) {
                fileType = ".tar.gz";
            }
        } else {
            return;
        }
        switch (fileType) {
            case ".gz":
                System.out.println("解压");
            default:
        }
    }
}
