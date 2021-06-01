package com.example.utils;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;

import com.monitorjbl.xlsx.StreamingReader;

@Slf4j
public class CsvUtil {
    public static void main(String[] args) {
        List<String> xlsx = FileViewer.getListFiles("D:\\绑定关系\\绑定关系整理\\新绑定关系\\新湖北\\湖北绑定关系-20210521", "xlsx", false);
        for (String s : xlsx) {
            csvs(s,s.replace("xlsx","csv"));
            log.info("{}转csv成功",s);
        }
        log.info("excel转csv全部结束");
    }
    //实现由Excel转csv的功能
    public static void csvs(String fileInput,String fileOutput){
        BufferedWriter bw=null;
        Workbook wb=null;
        try {
            //加载Excel文件设置加载的缓存
            wb=StreamingReader.builder().bufferSize(4096).rowCacheSize(200).open(new FileInputStream(fileInput));
            //设置csv转换储存的目标绝对路径，并设置编码
            bw=	new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileOutput),"GBK") );
            //读取文件信息
            Sheet sheetAt = wb.getSheetAt(0);
            for (Row row : sheetAt) {
                int i = 1;
                for (Cell cell : row) {
                    if (i==1){
                        if(cell.getCellTypeEnum()== CellType.STRING){
                            bw.write(cell.getStringCellValue());
                        }
                    }else {
                        if(cell.getCellTypeEnum()== CellType.STRING){
                            bw.write(","+cell.getStringCellValue());
                        }
                    }

                    if(cell.getCellTypeEnum()==CellType.NUMERIC){
                        bw.write(","+cell.getNumericCellValue());
                    }
                    if(cell.getCellTypeEnum()==CellType.BOOLEAN){
                        bw.write(","+cell.getBooleanCellValue());
                    }

                }
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }//关流
        finally{
            if(null!=wb){
                try {
                    wb.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if(null!=bw){
                    try {
                        bw.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}

