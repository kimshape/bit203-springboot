package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginProcessController {
//@GetMapping("/loginForm")
//public void loginForm() {
//	
//}
	@GetMapping("/loginForm")
	public String loginFrom() {
		return "loginForm";
		
	}
	
	@PostMapping("/loginCheck")
	public String loginCheck() {
		return "welcome";
		
	}
}
