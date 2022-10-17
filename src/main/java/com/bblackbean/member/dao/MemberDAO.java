package com.bblackbean.member.dao;

public interface MemberDAO {

	int join(String id, String hashText, String name, String email);

	String login(String id);

}
