package com.nhfc99;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("/login")
public class LoginController {

	private static Logger logger = (Logger) LoggerFactory.getLogger(LoginController.class);
	
}