package com.example.hello.model.vo;

public class Member {
	private String userId;
	private String userPw;
	private String userName;
	private String email;
	private int age;
	
	public Member() {
		// TODO Auto-generated constructor stub
		
	}
	
	public Member(String userId, String userPw, String userName, String email, int age) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.email = email;
		this.age = age;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 *  Property [email] not readable on type [com.bit.spring.model.template.vo.Member]
	 *  발생한 이유는 getEmail()이 없어서
	 * @return
	 */
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Member [userId=" + userId + ", userPw=" + userPw + ", userName=" + userName + ", email=" + email
				+ ", age=" + age + "]";
	}
}
