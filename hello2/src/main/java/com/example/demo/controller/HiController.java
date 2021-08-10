package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HiController {
	@GetMapping("/h")
	public String index() {
		System.out.println("index호출");
		return "index";
	}
}
