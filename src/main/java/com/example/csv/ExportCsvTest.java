package com.example.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class ExportCsvTest {

    public static void main(String[] args) throws Exception {
        System.out.println("------开始导出------");
        long l = System.currentTimeMillis();
//        testMillion();
        Excel2007AboveOperate("D:\\绑定关系\\绑定关系整理\\新绑定关系\\山东0611\\xml\\菏泽.xlsx");
        long l1 = System.currentTimeMillis();
        System.out.println("------结束导出------ 耗时:"+ (l1-l));
    }

    /**
     * 测试写100万数据需要花费多长时间
     */
    public static void testMillion() throws Exception {
        int times = 10000 * 10 * 10;
        Object[] cells = {"满100减15元", "100011", "123", "满100减15元", "100011", "123", "满100减15元", "100011", "123", "满100减15元", "100011", "123"};

        //  导出为CSV文件
        long t1 = System.currentTimeMillis();
        FileWriter writer = new FileWriter("D:\\test\\test1.csv");
        CSVPrinter printer = CSVFormat.EXCEL.print(writer);
        for (int i = 0; i < times; i++) {
            printer.printRecord(cells);
        }
        printer.flush();
        printer.close();
        long t2 = System.currentTimeMillis();
        System.out.println("CSV: " + (t2 - t1));

        //  导出为Excel文件
        long t3 = System.currentTimeMillis();
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();
        for (int i = 0; i < times; i++) {
            XSSFRow row = sheet.createRow(i);
            for (int j = 0; j < cells.length; j++) {
                XSSFCell cell = row.createCell(j);
                cell.setCellValue(String.valueOf(cells[j]));
            }
        }
        FileOutputStream fos = new FileOutputStream("D:\\test\\test2.xlsx");
        workbook.write(fos);
        fos.flush();
        fos.close();
        long t4 = System.currentTimeMillis();
        System.out.println("Excel: " + (t4 - t3));
    }

    public static void Excel2007AboveOperate(String filePath) throws IOException {
        XSSFWorkbook workbook1 = new XSSFWorkbook(new FileInputStream(new File(filePath)));
        SXSSFWorkbook sxssfWorkbook = new SXSSFWorkbook(workbook1, 100);
//            Workbook workbook = WorkbookFactory.create(new FileInputStream(new File(filePath)));
        Sheet first = sxssfWorkbook.getSheetAt(0);
        for (int i = 0; i < 100000; i++) {
            Row row = first.createRow(i);
            for (int j = 0; j < 11; j++) {
                if (i == 0) {
                    // 首行
                    row.createCell(j).setCellValue("column" + j);
                } else {
                    // 数据
                    if (j == 0) {
                        CellUtil.createCell(row, j, String.valueOf(i));
                    } else {
                        CellUtil.createCell(row, j, String.valueOf(Math.random()));
                    }
                }
            }
            FileOutputStream out = new FileOutputStream("D:\\workbook.xlsx");
            sxssfWorkbook.write(out);
            out.close();
        }
    }
}
