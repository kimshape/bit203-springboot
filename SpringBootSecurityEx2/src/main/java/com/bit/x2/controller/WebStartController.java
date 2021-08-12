package com.bit.x2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebStartController {
	@RequestMapping("/")
	public String index() {
		System.out.println("/");
		return "index";
	}
	@RequestMapping("/login")
	public String login() {
		System.out.println("/login");
		return "login";
	}
}
