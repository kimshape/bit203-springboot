package com.example.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.hello.model.vo.Member;

@Controller
public class HelloController {
	@GetMapping("/")
	public  String     hello(Model model) {
		model.addAttribute("foo", "hi^^");
		
		Member member= new Member();
		member.setActive(true);
		model.addAttribute("member", member);
		return "index";//index.html
	}
}
