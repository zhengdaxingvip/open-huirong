/**
 * Copyright (C) 2014-2017, Hrfax and/or its affiliates. All rights reserved.
 * Hrfax PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package cn.hrfax.open.exception;

import cn.hrfax.open.api.ResponseInfo;

/**
 * @author zhouyq
 * @Date 2017年4月15日
 */
public class BusiException extends RuntimeException {
	
	private static final long serialVersionUID = -1819933673915084443L;
	
	public final Object entity;
	
	public final Integer code;
	
	public final String message;

	public BusiException() {
        this(-1,"后台业务异常");
    }
	
	public BusiException(Integer code, String message) {
		
		this(null,code,message);
    }
	
	public BusiException(Object entity, Integer code, String message) {
		super(message);
		this.entity = entity;
        this.code = code;
        this.message = message;
       
        
    }

	/**
	 * @param taskExpired
	 */
	public BusiException(ResponseInfo responseInfo) {
		this(responseInfo.code,responseInfo.msg);
	}
}
