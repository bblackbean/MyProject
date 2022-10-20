package com.bblackbean.board.dao;

import java.util.ArrayList;

import com.bblackbean.board.dto.BoardDTO;

public interface BoardDAO {

	ArrayList<BoardDTO> list();

	void upHit(String idx);

	BoardDTO detail(String idx);

}
