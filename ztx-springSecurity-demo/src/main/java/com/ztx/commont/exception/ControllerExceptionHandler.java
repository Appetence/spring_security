package com.ztx.commont.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)//状态码
	@ExceptionHandler(UserException.class)//指定异常
	public Map<String ,Object> UserNotExitException(UserException ue){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", ue.getId());
		map.put("message", ue.getMessage());
		return map;
	}
}
