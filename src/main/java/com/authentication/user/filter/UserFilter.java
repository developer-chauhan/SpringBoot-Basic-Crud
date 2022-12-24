package com.authentication.user.filter;

import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

@Component
public class UserFilter implements Filter{
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain filterchain)throws IOException, ServletException{
		System.out.println("Remote host"+req.getRemoteHost());
		System.out.println("Remote Address"+req.getRemoteAddr());
		filterchain.doFilter(req, res);
	}
	public void init(FilterConfig filterConfig)throws ServletException {
		
	}
}
