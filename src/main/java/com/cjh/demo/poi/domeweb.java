package com.cjh.demo.poi;

import com.cjh.demo.model.Book;
import com.cjh.demo.model.User;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author
 * @site
 * @company
 * @create 2020-04-18 12:25
 */
public class domeweb {

    public List<Book> read(String path) throws IOException {
        List<Book> userList = new ArrayList<>();
        //获取Excl路径
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(path);
        //获取表
        XSSFSheet sheet= xssfWorkbook.getSheetAt(0);
        //获取最后一行的索引
        int lastRowNum = sheet.getLastRowNum();
        //由于第一行不需要从第二行开始
        for (int i = 1; i <=lastRowNum; i++) {
            //获取行
            XSSFRow row = sheet.getRow(i);
            if(row != null){
                List<String> list = new ArrayList<>();
                for (Cell cell : row) {
                     if (cell!=null){
                         //设置文本格式  将表格设置成字符串类型
                         cell.setCellType(Cell.CELL_TYPE_STRING);
                         //读取数据
                         String value = cell.getStringCellValue();

                         if (value!=null&&!"".equals(value)){
                             list.add(value);
                         }

                     }

                }
                if (list.size()>0){
                    Book user = new Book();
                    user.setBname(list.get(0));
                    user.setPrice(Float.parseFloat(list.get(1)));
                    user.setBid(Integer.parseInt(list.get(2)));
                    userList.add(user);
                }

            }
        }

        return userList;
    }


    public void write(List<Book> bookList,String path)throws  IOException{
     //创建一个工作空间
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        //创建工作表
        XSSFSheet sheet = xssfWorkbook.createSheet("书本");
        //创建行
        XSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("书本id");
        row.createCell(1).setCellValue("书本名");
        row.createCell(2).setCellValue("书本价格");
        for (int i = 0; i < bookList.size(); i++) {
            XSSFRow row1 =sheet.createRow(i+1);
            row1.createCell(0).setCellValue(bookList.get(i).getBid());
            row1.createCell(1).setCellValue(bookList.get(i).getBname());
            row1.createCell(2).setCellValue(bookList.get(i).getPrice());


        }

        FileOutputStream fileOutputStream = new FileOutputStream(path);
        xssfWorkbook.write(fileOutputStream);
        fileOutputStream.flush();
        fileOutputStream.close();
        xssfWorkbook.close();

    }
}
