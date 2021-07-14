package com.koreait.springmvc0714.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.koreait.springmvc0714.exception.DMLException;
import com.koreait.springmvc0714.model.board.service.BoardService;
import com.koreait.springmvc0714.model.domain.Board;

import lombok.Setter;

@Setter
public class UpdateContoller implements Controller{
	private BoardService boardService;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Board board = new Board();
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		int board_id = Integer.parseInt(request.getParameter("board_id"));
		
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		board.setBoard_id(board_id);
		
		ModelAndView mav = new ModelAndView();
		try{
			boardService.update(board);	
			mav.setViewName("redirect:/board/detail?board_id="+board_id);
		}catch(DMLException e) {
			e.printStackTrace();
			mav.addObject("e", e);
			mav.setViewName("error/result");
		}	
		return mav;
	}
}