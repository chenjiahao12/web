package com.cjh.demo.poi;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;

/**
 * @author
 * @site
 * @company
 * @create 2020-04-18 11:10
 * 将数据写入excl表格
 */
public class dome2 {
    public static void main(String[] args)throws Exception {
        //创建区间
        XSSFWorkbook workbook = new XSSFWorkbook();
        //创建表的名称
        XSSFSheet sheet = workbook.createSheet("工作表一");
        //创建行
        XSSFRow row = sheet.createRow(0);
        //创建单元格
        row.createCell(0).setCellValue("007");
        row.createCell(1).setCellValue("008");
        row.createCell(2).setCellValue("009");

        XSSFRow row1 = sheet.createRow(1);
        //创建单元格
        row1.createCell(0).setCellValue("003");
        row1.createCell(1).setCellValue("004");
        row1.createCell(2).setCellValue("005");

        //输出流
        FileOutputStream outputStream= new FileOutputStream("E:\\学习资料\\导入导出\\dome2.xlsx");
        workbook.write(outputStream);
        outputStream.flush();
        //释放资源
        outputStream.close();
        workbook.close();
        System.err.println("ok");
    }
}
