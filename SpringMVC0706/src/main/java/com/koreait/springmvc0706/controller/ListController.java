package com.koreait.springmvc0706.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.koreait.springmvc0706.model.board.dao.BoardDAO;
import com.koreait.springmvc0706.model.domain.Board;

public class ListController implements Controller{

	private BoardDAO boardDAO;
	
	//setter주입을 위해
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<Board> boardList = boardDAO.selectAll();
		ModelAndView mav = new ModelAndView(); //4단계;
		mav.setViewName("board/list"); //접두어 접미어를 뺀 뷰이름 반환
		mav.addObject("boardList", boardList); //request에 setAttribute한 것과 동일
		
		return mav;
	}

}
