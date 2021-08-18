package com.bit.x3.model.util;

public enum MemberRole {
	ADMIN("ROLE_ADMIN"),
	MEMBER("ROLE_MEMBER");
	
	private String value;
	private MemberRole(String role) {
		value = role ;
	}
	public String getValue() {
		return value;
	}
}
