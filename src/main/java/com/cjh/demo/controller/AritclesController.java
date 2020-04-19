package com.cjh.demo.controller;

import com.cjh.demo.model.Articles;
import com.cjh.demo.model.Book;
import com.cjh.demo.poi.ExportExcelUtils;
import com.cjh.demo.service.ArticlesService;

import com.cjh.demo.util.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author
 * @site
 * @company
 * @create 2020-04-11 15:47
 */
@ResponseBody
@Controller
@RequestMapping("/Aritcles")
@Api(value = "AritclesController",description = "文章")
public class AritclesController {

    @Autowired
    private ArticlesService articlesService;

    private JsonData jsonData = null;


    @ApiOperation(value = "查询文章",notes ="查询文章" )
    @ApiResponse(code = 200,message = "文章获取成功")
    @PostMapping("/list")
    public ResultCode<Articles,PageBean> AritclesList(Articles record, HttpServletRequest request){

        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);
        List<Map> list = articlesService.selectAllPager(record,pageBean);
        if(list.size()!=0){

            return new ResultCode("查询成功",list,pageBean);
        }
        else{
            return new ResultCode("查询成功",null,null);
        }

    }


    @ApiOperation(value = "修改文章",notes ="修改文章" )
    @ApiResponses({
            @ApiResponse(code = 200,message = "文章修改成功"),
            @ApiResponse(code = 500,message = "文章修改失败")
    })
    @PostMapping ("/update")
    public ResultData AritclesUpdate(Articles articles){
        int i = articlesService.updateByPrimaryKeySelective(articles);
       if(i>0){
            return new ResultData("修改成功",null);
       }else {
           return new ResultData(CodeMsg.UPDATE_ERR,null);
       }

    }

    @ApiOperation(value = "文章新增",notes ="文章新增" )
    @ApiResponses({
            @ApiResponse(code = 200,message = "新增成功"),
            @ApiResponse(code = 500,message = "新增失败")
    })
    @PostMapping("/Insert")
    public ResultData AritclesInsert(Articles articles){
        int i = articlesService.insertSelective(articles);
        if(i>0){
            return  new ResultData("新增成功",null);
        }else {
            return  new ResultData(500,"新增失败",null);
        }
    }

    @ApiOperation(value = "文章删除",notes ="文章删除" )
    @ApiResponses({
            @ApiResponse(code = 200,message = "删除成功"),
            @ApiResponse(code = 500,message = "删除失败")
    })
    @PostMapping("/delete")
    public ResultData Aritclesdelete(Articles articles){
        int i = articlesService.deleteByPrimaryKey(articles.getId());
        if(i>0){
            return new ResultData("删除成功",null);
        }else {
            return new ResultData(500,"删除失败",null);
        }
    }
    @ApiOperation(value = "查询文章",notes ="查询文章" )
    @ApiResponses({
            @ApiResponse(code = 200,message = "根据id查询文章成功"),
            @ApiResponse(code = 500,message = "根据id查询文章失败")
    })
    @PostMapping("/getid")
    public ResultData<Articles> Aritclesgetid(Articles articles){
        Articles articles1 = articlesService.selectByPrimaryKey(articles.getId());
        return new ResultData(200,"查询成功",articles1);
    }
        @ApiOperation(value = "文章导出",notes ="文章导出" )
        @ApiResponses({
                @ApiResponse(code = 200,message = "文章导出成功"),
                @ApiResponse(code = 500,message = "文章导出失败")
        })
        @GetMapping("/getAll")
     public void Export(HttpServletResponse response){
         //得到所有要导出的数据
         List<Articles> orderlist =articlesService.getAll();
         //定义导出的excel名字
         String excelName = "文章表";

         //获取需要转出的excel表头的map字段
         LinkedHashMap<String, String> fieldMap = new LinkedHashMap<>();
         fieldMap.put("id","文章id");
         fieldMap.put("title","标题");
         fieldMap.put("body","内容");

         //导出用户相关信息
         new ExportExcelUtils().export(excelName,orderlist,fieldMap,response);

     }


}
