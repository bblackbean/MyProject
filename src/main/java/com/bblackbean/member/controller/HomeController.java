package com.bblackbean.member.controller;

import javax.servlet.http.HttpSession;

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
		String hashText = encoder.encode(pw);
		
		String msg = "회원가입에 실패했습니다.";
		String page = "joinForm";
		int row = service.join(id,hashText,name,email);
		logger.info("params:::"+id+"/"+hashText+"/"+name+"/"+email);
		
		if(row>0) {
			msg = "회원가입에 성공했습니다.";
			page = "login";
		}
		model.addAttribute("msg",msg);
		
		return page;
	}
	
	//로그인
	@RequestMapping(value="/login")
	public String join(Model model, HttpSession session, @RequestParam String id, @RequestParam String pw) {
		String loginId = service.login(id,pw);
		String msg = "아이디 또는 비밀번호를 확인하세요.";
		String page = "login";
		
		if(loginId != null) {
			page = "list";
		} else {
			model.addAttribute("msg", msg);
		}
		return page;
	}
}
