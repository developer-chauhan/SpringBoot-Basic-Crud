package com.authentication.user.controller;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class HomeController {
	org.slf4j.Logger logger= LoggerFactory.getLogger(HomeController.class);
	@GetMapping("/")
	public String home() {
		return ("<h1>Welcome</h1>");
	}
	@GetMapping("/admin")
	public String admin() {
		logger.trace("inside admin mapping");
		return ("<h1>Welcome admin</h1>");
	}
}
