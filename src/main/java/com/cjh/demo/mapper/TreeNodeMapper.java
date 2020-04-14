package com.cjh.demo.mapper;

import com.cjh.demo.model.TreeNode;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TreeNodeMapper {
    int deleteByPrimaryKey(Integer tree_node_id);

    int insert(TreeNode record);

    int insertSelective(TreeNode record);

    TreeNode selectByPrimaryKey(Integer tree_node_id);

    int updateByPrimaryKeySelective(TreeNode record);

    int updateByPrimaryKey(TreeNode record);

     List<TreeNode> getTree();

     List<TreeNode> selectMenuChildrenByMenuNo(TreeNode treeNode);
}