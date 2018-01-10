package com.website.exception;

import com.website.enums.ResultEnum;

@SuppressWarnings("serial")
public class GirlException extends RuntimeException {
	private Integer code;
	
	public GirlException(ResultEnum resultEnum){
		super(resultEnum.getMsg());
		this.code = resultEnum.getCode();
		
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
}
