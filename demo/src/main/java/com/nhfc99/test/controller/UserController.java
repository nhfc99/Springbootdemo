package com.nhfc99.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nhfc99.test.service.UserService;

@Controller
@RequestMapping("/base")
public class UserController {
	@Autowired
	UserService userService;
	
	@ResponseBody
	@GetMapping(value="/users")
	public Object getUsers() {
		return userService.getAllUsers();
	}
}
