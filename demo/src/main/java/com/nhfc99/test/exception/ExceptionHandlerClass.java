package com.nhfc99.test.exception;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandlerClass {
	@ResponseBody
	@ExceptionHandler(value = Exception.class)
	public Object handleException(Exception e, HttpRequest httpRequest) {
		return "报错了";
	}
}
