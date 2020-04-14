package com.cjh.demo.service.impl;

import com.cjh.demo.mapper.TreeNodeMapper;
import com.cjh.demo.model.TreeNode;
import com.cjh.demo.service.TreeNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 * @site
 * @company
 * @create 2020-04-11 13:52
 */
@Service
public class TreeNodeServiceImpl implements TreeNodeService {
    @Autowired
    private TreeNodeMapper treeNodeMapper;

    @Override
    public int deleteByPrimaryKey(Integer tree_node_id) {
        return 0;
    }

    @Override
    public int insert(TreeNode record) {
        return 0;
    }

    @Override
    public int insertSelective(TreeNode record) {
        return 0;
    }

    @Override
    public TreeNode selectByPrimaryKey(Integer tree_node_id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(TreeNode record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(TreeNode record) {
        return 0;
    }

    @Override
    public List<TreeNode> getTree() {
        return treeNodeMapper.getTree();
    }

    @Override
    public List<TreeNode> selectMenuChildrenByMenuNo(TreeNode treeNode) {
        return treeNodeMapper.selectMenuChildrenByMenuNo(treeNode);
    }
}
