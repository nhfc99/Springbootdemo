package com.nhfc99.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nhfc99.test.service.UserService;

@Controller
@RequestMapping("/base")
@PropertySource({ "classpath:application.properties" })
public class UserController {
	@Autowired
	UserService userService;

	@Value("${web.own.port}")
	private String port;

	@ResponseBody
	@GetMapping(value = "/users")
	public Object getUsers() {
		return userService.getAllUsers();
	}

	@ResponseBody
	@GetMapping(value = "/usercount")
	public Object selectUserCount() {
		return userService.selectUserCount();
	}

	@ResponseBody
	@GetMapping("/testconfig")
	public String testConfig() {
		return port;
	}
}
