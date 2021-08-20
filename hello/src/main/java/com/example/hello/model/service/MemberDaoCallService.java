package com.example.hello.model.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.hello.model.vo.Member;


public interface MemberDaoCallService {
	Member getMember( String userId,String userPw);


	List<Member> memberList();

	List<Member> insertMember(Member member);
}
