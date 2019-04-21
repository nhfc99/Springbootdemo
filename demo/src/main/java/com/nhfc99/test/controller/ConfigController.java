package com.nhfc99.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nhfc99.test.config.Config;

@Controller
@RequestMapping("/test/config")
public class ConfigController {
	@Autowired
	Config config;
	
	@GetMapping("/getname")
	@ResponseBody
	public String testName() {
		return config.getName();
	}
}
