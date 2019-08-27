package com.nhfc99.shiro;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class MyExceptionResolver implements HandlerExceptionResolver {
	@Override
	public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Object o, Exception e) {
		if (e instanceof UnauthenticatedException) {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("forward:/login/authenticationErr");
			return mv;
		}
		
		if (e instanceof UnauthorizedException) {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("forward:/login/authorizationErr");
			return mv;
		}
		
		return null;
	}
}
