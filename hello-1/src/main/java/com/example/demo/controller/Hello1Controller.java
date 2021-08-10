package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Hello1Controller {
	@GetMapping("/hi")
	public String hello1() {
		return "index";//index.html을 찾는다 (스프링부트가)
		
	}

}
