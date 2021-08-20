package com.example.hello.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hello.model.dao.MemberDao;
import com.example.hello.model.vo.Member;

@Service
public class MemberDaoCallServiceImpl implements MemberDaoCallService {
	@Autowired
	private MemberDao memberDao; 
	
	@Override
	public Member getMember(String userId, String userPw) {
		Member member=  memberDao.getMember(userId, userPw);
		if(member.getAge() >=20) {
			
		}else {
			
		}
		return member ;
	}

	@Override
	public List<Member> memberList() {
		
		return memberDao.memberList();
	}

	@Override
	public List<Member> insertMember(Member member) {
		
		memberDao.insertMember(member);
		return memberDao.memberList();
	}

}
