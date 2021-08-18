package com.bit.x3.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bit.x3.model.dao.MemberDao;
import com.bit.x3.model.util.MemberRole;
import com.bit.x3.model.vo.Member;
@Service
public class MemberUserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private MemberDao memberDao;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("MemberUserDetailsServiceImpl  username:"+username);
		Member member = memberDao.findMember(username);
		System.out.println("loadUserByUsername member : " + member); 
		
		// 인가를 위한 권한 설정
		
		
		User user = null;
		if(member!=null) {
			
			Set<GrantedAuthority> grantedAuthorities = new HashSet<>(2);
//			if(username.equals("bit203")) {
//				grantedAuthorities.add(new SimpleGrantedAuthority(MemberRole.ADMIN.getValue()));
//			}else {
//				grantedAuthorities.add(new SimpleGrantedAuthority(MemberRole.MEMBER.getValue()));
//			}
//			String role = username.equals("bit203") ? MemberRole.ADMIN.getValue() : MemberRole.MEMBER.getValue() ;
			
			grantedAuthorities.add(new SimpleGrantedAuthority(username.equals("bit203") ? MemberRole.ADMIN.getValue() : MemberRole.MEMBER.getValue()));
			user = new User(member.getUserId(), member.getUserPw(), grantedAuthorities);
			System.out.println("user "+ user);
		}
		
		return user;
	}

}











