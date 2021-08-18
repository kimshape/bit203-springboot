package com.bit.x3.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.bit.x3.model.vo.Member;

@Mapper
public interface MemberDao {
	
	Member getMember(@Param("userId") String userId , @Param("userPw") String userPw);
	Member findMember(@Param("userId") String userId );
//	public interface MemberDaoMyBatis {
//		List<Member>  getAllMember();
//	
	@Select("select  userId, userPw, userName, email, age    from  member")
	List<Member>  memberList();
	
	
	void  insertMember(Member member);
	
}
