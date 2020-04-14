package com.cjh.demo.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author
 * @site
 * @company
 * @create 2020-04-13 23:22
 */
@Data
@ApiModel(value = "响应数据",description = "响应信息")
public class ResultCode<T,Y> {

    @ApiModelProperty("响应码")
    private Integer code;
    @ApiModelProperty("响应信息")
    private String msg;
    @ApiModelProperty("响应数据")
    private T data;
    @ApiModelProperty("响应数据")
    private Y pageBean;

    public ResultCode(Integer code,String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultCode(String msg, T data,Y pageBean) {
        this.code = 200;
        this.msg = msg;
        this.data = data;
        this.pageBean =pageBean;
    }
}
