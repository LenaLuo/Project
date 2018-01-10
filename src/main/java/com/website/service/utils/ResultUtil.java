package com.website.service.utils;

import com.website.domain.Result;

public class ResultUtil {
	public static Result<Object> success(Object object){
		Result<Object> result = new Result<Object>();
		result.setCode(0);
		result.setMsg("成功");
		result.setData(object);
		return result;
	}
	public static Result<Object> success(){
		return success(null);
	}
	@SuppressWarnings("rawtypes")
	public static Result error(Integer code, String msg){ 
		Result result = new Result();
		
		result.setCode(code);
		result.setMsg(msg);
		return result;
	}
}
