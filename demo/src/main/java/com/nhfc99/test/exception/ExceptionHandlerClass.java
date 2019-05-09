package com.nhfc99.test.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandlerClass {
	@ResponseBody
	@ExceptionHandler(value = MyException.class)
	public Object handleException(MyException e) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", e.getCode());
		map.put("errorMsg", e.getErrorMsg());
		return map;
	}
}
