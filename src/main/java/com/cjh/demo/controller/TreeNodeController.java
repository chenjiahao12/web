package com.cjh.demo.controller;

import com.cjh.demo.model.TreeNode;
import com.cjh.demo.service.TreeNodeService;
import com.cjh.demo.util.JsonData;
import com.cjh.demo.util.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author
 * @site
 * @company
 * @create 2020-04-11 13:55
 */

@Controller
@RequestMapping("/Tree")
@Api(value = "TreeNodeController",description = "树形菜单")
public class TreeNodeController {

@Autowired
    private TreeNodeService treeNodeService;

    @ResponseBody
    @ApiOperation(value = "树形菜单",notes ="树形菜单" )
    @ApiResponse(code = 200,message = "菜单获取成功")
    @PostMapping("/list")
    public ResultData<TreeNode> MenuTree(){
        List<TreeNode> menuList = treeNodeService.getTree();
        for (TreeNode treeNode : menuList) {
            List<TreeNode> treeNodes = treeNodeService.selectMenuChildrenByMenuNo(treeNode);
            treeNode.setChildrenList(treeNodes);
        }

        return new ResultData("获取成功",menuList);
    }

 /*   *//*递归查询*//*
    private void getChildern(TreeNode tree){
        List<TreeNode> treeNodes = treeNodeService.selectMenuChildrenByMenuNo(tree);
        tree.setChildrenList(treeNodes);
        //如果还有子菜单就进行递归
        if(treeNodes.size()>0){
            for (TreeNode treeNode : treeNodes) {
                getChildern(treeNode);
            }
        }
    }*/
}
