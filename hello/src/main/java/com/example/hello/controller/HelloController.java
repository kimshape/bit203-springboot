package com.example.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.hello.model.vo.Member;

import sample.UserDTO_VO_Bean;

@Controller
public class HelloController {
	@GetMapping("/")
	public  String     hello(Model model) {
		model.addAttribute("foo", "hi^^");
		UserDTO_VO_Bean bean = new UserDTO_VO_Bean();
		bean.setActive(false);
		
		Member member= new Member();
		member.setActive(true);
		model.addAttribute("member", member);
		model.addAttribute("bean", bean);
		return "index";//index.html
	}
}
