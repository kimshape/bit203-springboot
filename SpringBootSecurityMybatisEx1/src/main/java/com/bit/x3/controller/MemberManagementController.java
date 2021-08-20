package com.bit.x3.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit.x3.model.dao.MemberDao;
import com.bit.x3.model.vo.Member;
import com.fasterxml.jackson.annotation.JsonRawValue;

@Controller
public class MemberManagementController {
	
	
	private static final Logger log = LoggerFactory.getLogger(MemberManagementController.class);
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private MemberDao memberDao;
	
	// index
	@GetMapping("/")
	public String index() {
	
		return "/index";
	}
	
	//로그인
	@RequestMapping("/login")
	public void memberLogin() {
		log.info("login");
	}
	
	@RequestMapping("/loginSucces")
	public String loginSucces(@AuthenticationPrincipal User user, Map<String, Object> model, SecurityContextHolderAwareRequestWrapper requestWrapper) {
		//System.out.println("loginSucces  ==>"+user);
		String nextPage = "/loginSucces";
		if(user==null) {
			model.put("message", "유요하지 않은 데이터");
			nextPage = "redirect:/denied";
		}else {
			if(requestWrapper.isUserInRole("ADMIN")) {
				
				//////
				nextPage = "redirect:/admin/main";
			}else {
				
				model.put("currentMemberId", user.getUsername());
				nextPage = "/member/main";
			}
		}
		return nextPage;
	}
	
	@GetMapping("/admin/main")
	public String adminMain(@AuthenticationPrincipal User user, Map<String, Object> model, SecurityContextHolderAwareRequestWrapper requestWrapper) {
//		System.out.println("loginSucces  ==>"+user);
//		System.out.println("loginSucces  ==>"+requestWrapper.isUserInRole("ADMIN"));
		
		List<Member> members = memberDao.memberList();
		model.put("members", members)  ;
		model.put("currentAdminId", user.getUsername());
		return "/admin/main";
	}
	
	
	@RequestMapping("/logoutSucces")
	public String logoutSucces() {
		System.out.println("logoutSucces  ==>");
		return "/logoutSucces";
	}
	
	@GetMapping("/denied")
	public void denied() {
		
	}
	
	@GetMapping("/member/main")
	public String memberInfo(@AuthenticationPrincipal User user,Model model) {
		model.addAttribute("currentMemberId", user.getUsername()); 
		return "/member/main";
	}
	
	
	
	//회원가입을 위한 form call
	@GetMapping("/memberNew")
	public String memberNewFormCall(Member member) {
		log.info("memberNewFormCall()");
		return "/member/joinForm";
	}
	// 회원가이빌행 , 데이타베이스에 저장
	@PostMapping("/memberNew")
	public String memberNew(Member member) {
		log.info(member.toString());
//		암호에 대해서 암호화시킨다
		member.setUserPw(passwordEncoder.encode(member.getUserPw()));
		log.info("암호화된 암호 :"+ member.getUserPw());
//        dao 의 insert 담당하는 메소드 호출
		memberDao.insertMember(member);
//        결과를 받아서 
		log.info("memberNew()  return 전");
		return "redirect:/login";
	}
}
