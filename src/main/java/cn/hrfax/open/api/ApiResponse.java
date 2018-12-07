package cn.hrfax.open.api;

import cn.hrfax.open.exception.BusiException;

import java.io.Serializable;


/**
 * <p>
 * Title: ApiResponse.java<／p>
 * <p>
 * Description: <／p>
 * 
 * @author yh.yu
 * @date 2015年8月26日
 */
public class ApiResponse implements Serializable {

	private static final long serialVersionUID = 1189991146334068265L;
	
	public static final ApiResponse EXCEPTION = new ApiResponse(ResponseInfo.EXCEPTION);

	public static final ApiResponse SUCCESS = new ApiResponse();

	public static final ApiResponse AUTHENTICATION_FAILURE = new ApiResponse(ResponseInfo.AUTHENTICATION_FAILURE);
	
	public static final ApiResponse SIGN_NOT_MATCH = new ApiResponse(ResponseInfo.SIGN_MISMATCHING);
	
	private Page page;

	private int code; // 返回响应码:0=成功返回，其他=错误返回

	private String msg; // 返回响应消息

	private Object data; // 返回数据

	private Object cfgData; // 配置数据
	
	public static ApiResponse getInstance(Object data) {
		ApiResponse response = new ApiResponse();
		return response.addData(data);
	}
	
	public static ApiResponse getInstance(Object data, Object cfgData) {
		ApiResponse response = new ApiResponse();
		return response.addData(data).addCfgData(cfgData);
	}

	public ApiResponse() {
		this(ResponseInfo.SUCCESS);
	}

	/**
	 *
	 * @param responseInfo
	 */
	public ApiResponse(ResponseInfo responseInfo) {
		this.code = responseInfo.code;
		this.msg = responseInfo.msg;
	}
	
	public ApiResponse(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}


	public ApiResponse(BusiException e) {
		this.code = e.code;
		this.msg = e.message;
		this.data = e.entity;
	}

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

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	public ApiResponse addData(Object data) {
		this.data = data;
		return this;
	}
	
	public ApiResponse addCfgData(Object cfgData) {
		this.cfgData = cfgData;
		return this;
	}
	
	public ApiResponse addPage(Page page) {
		this.setPage(page);
		return this;
	}

	/**
	 * @return the cfgData
	 */
	public Object getCfgData() {
		return cfgData;
	}

	/**
	 * @param cfgData
	 *            the cfgData to set
	 */
	public void setCfgData(Object cfgData) {
		this.cfgData = cfgData;
	}

	/**
	 * @return the page
	 */
	public Page getPage() {
		return page;
	}

	/**
	 * @param page the page to set
	 */
	public void setPage(Page page) {
		this.page = page;
	}
}
