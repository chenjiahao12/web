package com.cjh.demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.ToString;

@ToString
@ApiModel(value = "用户实体类",description = "这是用户对象")
public class User {

    /* @ApiModelProperty(hidden=true) 表示不在swagger中显示*/

    @ApiModelProperty(value = "用户名",required = true)
    private String uname;
    @ApiModelProperty(value = "用户密码" ,required = true)
    private String pwd;

    public User(String uname, String pwd) {
        this.uname = uname;
        this.pwd = pwd;
    }

    public User() {
        super();
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}