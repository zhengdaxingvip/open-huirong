package cn.hrfax.open.api;

public enum ResponseInfo {

	SUCCESS(0, "success"), 
	EXCEPTION(-1, "系统异常"),
	
	PARAM_MISSING(1000,"参数缺失"),
	ILLEGAL_PARAM(1001,"参数非法"),
	AUTHENTICATION_FAILURE(1004,"认证失败"), 
	
	REQUEST_TIMEOUT(1010,"请求超时"), 
	APIKEY_MISSING(1011,"接入key缺失"),
	SIGN_MISMATCHING(1012,"签名不匹配"),
	CONF_MISSING(1013,"缺少配置"),
	
	ORG_REL_MISSING(1020,"机构未绑定"),
	ORG_MISSING(1021,"机构不存在"),
	BUSI_MISSING(1022,"机构业务不存在"), 
	;

	public final int code;

	public final String msg;

	private ResponseInfo(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	public Integer getCode() {
		return code;
	}
	
	public String getMsg(){
		return msg;
	}
}
