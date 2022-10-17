package com.bblackbean.member.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bblackbean.member.service.MemberService;

@Controller
public class HomeController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired MemberService service;

	//로그인 페이지
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		return "login";
	}
	
	//회원가입 페이지 이동
	@RequestMapping(value="/joinForm.go")
	public String joinForm(Model model) {
		logger.info("회원가입 페이지 이동");
		return "joinForm";
	}
	
	//회원가입(암호화)
	@RequestMapping(value="/join")
	public String join(Model model, @RequestParam String id, @RequestParam String pw,
			@RequestParam String name, @RequestParam String email) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		return "";
	}
}
