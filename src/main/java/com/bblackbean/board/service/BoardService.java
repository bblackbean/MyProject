package com.bblackbean.board.service;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.bblackbean.board.dao.BoardDAO;
import com.bblackbean.board.dto.BoardDTO;

@Service
public class BoardService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired BoardDAO dao;
	
	public ModelAndView list(HttpSession session) {
		String page = "login";
		logger.info("게시판 호출 서비스 도착");
		ModelAndView mav = new ModelAndView();
		
		if (session.getAttribute("loginId") != null) {
			logger.info("if문 도착");
			ArrayList<BoardDTO> list = dao.list();
			mav.addObject("list", list);
			page = "list";
		} else {
			mav.addObject("msg", "로그인이 필요한 서비스입니다.");
		}
		mav.setViewName(page);
		
		return mav;
	}
}
