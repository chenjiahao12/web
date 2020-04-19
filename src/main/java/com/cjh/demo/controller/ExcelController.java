package com.cjh.demo.controller;

import com.cjh.demo.model.Book;
import com.cjh.demo.poi.ExportExcelUtils;
import com.cjh.demo.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;
import java.util.List;


@Controller
@Api(value = "ExcelController",description = "导出案例")
public class ExcelController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private BookService bookService;
    @ApiOperation(value = "导出数据",notes ="导出" )
    @GetMapping(value = "/excel")
    public void ExportBankCkeckInfo(HttpServletResponse response, HttpServletRequest request){
        //得到所有要导出的数据
        List<Book> orderlist =bookService.getAll();
        //定义导出的excel名字
        String excelName = "书本表";

        //获取需要转出的excel表头的map字段
        LinkedHashMap<String, String> fieldMap = new LinkedHashMap<>();
        fieldMap.put("bid","书本id");
        fieldMap.put("bname","书本名");
        fieldMap.put("price","书本价格");

        //导出用户相关信息
        new ExportExcelUtils().export(excelName,orderlist,fieldMap,response);
    }






}

