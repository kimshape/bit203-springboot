package com.example.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.hello.model.dao.MemberDao;
import com.example.hello.model.service.MemberDaoCallService;
import com.example.hello.model.vo.Member;

@Controller
public class LoginProcessController {
	
	@Autowired
	private MemberDao memberDao;
	
	
//	@GetMapping("/loginForm")
//	public void loginForm() {
//		
//	}
//	
	@GetMapping("/loginForm")
	public String loginForm() {
		return "loginForm" ;
	}
	
	@Autowired
	private MemberDaoCallService memberDaoCallService;
			
	@PostMapping("/loginCheck")
	public String loginCheck(String userId, String userPw ,Model model) {
		System.out.println("userId : "+userId);
		
		Member member = memberDaoCallService.getMember(userId, userPw);
//		존재: welcome.html
//	    존재하지 않는다면 : loginForm.html
//		
		if(member==null) {
			return "redirect:/loginForm";
		}
		model.addAttribute("userId", userId);
		member.setActive(true);
		model.addAttribute("member", member);
		
		return "welcome" ;
	}
	
	@GetMapping("/memberList")
	public  void  memberList(Model model) {
		System.out.println("${memberList}");
		model.addAttribute( "memberList"  , memberDao.memberList());
	}
	
	@GetMapping("/memberForm")
	public void memberForm() {
		
	}
	
	
	@PostMapping("/insertMember")
	public String insertMember(Member member) {
		memberDao.insertMember(member);
		return "redirect:/memberList";
	}
	
	@PostMapping("/insertMemberService")
	public String insertMemberService(Member member,Model model) {
		model.addAttribute("memberList",memberDaoCallService.insertMember(member));
		return "/memberList";
	}
	
}
