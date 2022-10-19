package com.bblackbean.board.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bblackbean.board.service.BoardService;

@Controller
public class BoardController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired BoardService service;
	
	//리스트 호출
	@RequestMapping(value= {"/list","/list.do"})
	public ModelAndView list(HttpSession session) {
		logger.info("리스트 요청");
		return service.list(session);
	}
}
