package com.website.handle;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.website.domain.Result;
import com.website.exception.GirlException;
import com.website.service.utils.ResultUtil;


@ControllerAdvice
public class ExceptionHandle {
	
	@SuppressWarnings("rawtypes")
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Result handle(Exception e){
		if(e instanceof GirlException){
			GirlException girlException = (GirlException) e;
			return ResultUtil.error(girlException.getCode(), girlException.getMessage());
		}else{
			return ResultUtil.error(-1, "未知错误");
		}
		
	}
}
