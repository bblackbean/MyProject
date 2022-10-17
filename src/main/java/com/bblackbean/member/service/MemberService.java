package com.bblackbean.member.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bblackbean.member.dao.MemberDAO;

@Service
public class MemberService {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired MemberDAO dao;
	
	public int join(String id, String hashText, String name, String email) {
		return dao.join(id,hashText,name,email);
	}
	
	public String login(String id, String pw) {
		String hashPw = dao.login(id); //암호화된 pw 가져오기
		String loginId = null;
		logger.info("확인:::"+hashPw);
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if(encoder.matches(pw, hashPw)) {
			loginId = id;
		}
		return loginId;
	}
}
