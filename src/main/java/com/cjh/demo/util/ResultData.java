package com.cjh.demo.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 控制器返回封装
 * @author 伺机
 *
 * @param <T>
 */
@ApiModel(value = "响应数据",description = "响应信息")
public class ResultData<T> {
	@ApiModelProperty("响应码")
	private Integer code;
	@ApiModelProperty("响应信息")
	private String msg;
	@ApiModelProperty("响应数据")
	private T data;
	
	public ResultData(Integer code,String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	
	public ResultData(String msg, T data) {
		this.code = 200;
		this.msg = msg;
		this.data = data;
	}

	
	public  ResultData(CodeMsg resultCode, T data) {
		this.code = resultCode.getCode();
		this.msg = resultCode.getMsg();
		this.data = data;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
}
