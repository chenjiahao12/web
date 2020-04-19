package com.cjh.demo.poi;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author
 * @site
 * @company
 * @create 2020-04-18 10:56
 * 获取excl的数据
 */
public class doem1 {
    public static void main(String[] args)throws Exception {

    /*    String selectedText = {"["id"",""title"",""body"]"}
        StringUtils.strip(selectedText.toString(),"{}");*/



       /* //获取文件位置
        XSSFWorkbook workbook = new XSSFWorkbook("E:\\学习资料\\导入导出\\dome.xlsx");
        //获取工作表
        XSSFSheet sheet = workbook.getSheetAt(0);
        //获取行
        for (Row row : sheet) {
            //获取单元格
            for (Cell cell : row) {
                //获取单元格的值
                String value = cell.getStringCellValue();
                System.err.println(value);
            }
        }
        //释放资源
        workbook.close();*/
    }
}
