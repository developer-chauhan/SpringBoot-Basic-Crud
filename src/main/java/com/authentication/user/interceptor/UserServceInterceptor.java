package com.authentication.user.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class UserServceInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse rep,
			Object handler) throws Exception{
		System.out.println("this is pre handler function");
		return true;
	}
	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse rep,
			Object handler, ModelAndView movie) throws Exception{
		System.out.println("this is post handler function");
	}
	@Override
	public void afterCompletion(HttpServletRequest req, HttpServletResponse rep,
			Object handler, Exception exception) throws Exception {
		System.out.println("this is after completion");
	}
}
