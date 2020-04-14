package com.cjh.demo.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.HashMap;

/**
 * 服务器返回给客户端的JSON格式的数据
 *
 */
@ApiModel(value = "响应数据",description = "响应信息")
public class JsonData extends HashMap<String, Object> implements Serializable {

	private static final long serialVersionUID = -8855960778711040221L;
	@ApiModelProperty(value = "响应码",required = true)
	private int code;
	@ApiModelProperty(value = "响应信息",required = true)
	private String msg;
	@ApiModelProperty(value = "响应数据",required = true)
	private Object result;
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public JsonData(int code, String msg, Object result) {
		super();
		this.put("code", code);
		this.put("msg", msg);
		this.put("result", result);
	}

	public JsonData() {
		super();
	}

}
