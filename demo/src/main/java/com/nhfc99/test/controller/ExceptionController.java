package com.nhfc99.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test/exception")
public class ExceptionController {
	@ResponseBody
	@GetMapping("index")
	public String Index() {
		int number = 1/0;
		
		return "ceshi";
	}
}
