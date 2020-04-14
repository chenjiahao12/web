package com.cjh.demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.ToString;

import java.util.List;
@ToString
@ApiModel(value = "树形菜单实体类",description = "菜单对象")
public class TreeNode {
    @ApiModelProperty(value = "id",required = true)
    private Integer tree_node_id;
    @ApiModelProperty(value = "名称",required = true)
    private String tree_node_name;
    @ApiModelProperty(value = "父id",required = true)
    private Integer tree_node_type;
    @ApiModelProperty(value = "子id",required = true)
    private Integer parent_node_id;
    @ApiModelProperty(value = "路径",required = true)
    private String url;
    @ApiModelProperty(value = "序列",required = true)
    private Integer position;
    @ApiModelProperty(value = "图标",required = true)
    private String icon;
    @ApiModelProperty(value = "子菜单",required = true)
    private List<TreeNode> childrenList;

    public List<TreeNode> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<TreeNode> childrenList) {
        this.childrenList = childrenList;
    }

    public TreeNode(Integer tree_node_id, String tree_node_name, Integer tree_node_type, Integer parent_node_id, String url, Integer position, String icon) {
        this.tree_node_id = tree_node_id;
        this.tree_node_name = tree_node_name;
        this.tree_node_type = tree_node_type;
        this.parent_node_id = parent_node_id;
        this.url = url;
        this.position = position;
        this.icon = icon;
    }

    public TreeNode() {
        super();
    }

    public Integer getTree_node_id() {
        return tree_node_id;
    }

    public void setTree_node_id(Integer tree_node_id) {
        this.tree_node_id = tree_node_id;
    }

    public String getTree_node_name() {
        return tree_node_name;
    }

    public void setTree_node_name(String tree_node_name) {
        this.tree_node_name = tree_node_name;
    }

    public Integer getTree_node_type() {
        return tree_node_type;
    }

    public void setTree_node_type(Integer tree_node_type) {
        this.tree_node_type = tree_node_type;
    }

    public Integer getParent_node_id() {
        return parent_node_id;
    }

    public void setParent_node_id(Integer parent_node_id) {
        this.parent_node_id = parent_node_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}