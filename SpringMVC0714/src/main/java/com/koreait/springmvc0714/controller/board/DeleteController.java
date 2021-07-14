package com.koreait.springmvc0714.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.koreait.springmvc0714.exception.DMLException;
import com.koreait.springmvc0714.model.board.service.BoardService;

import lombok.Setter;

@Setter
public class DeleteController implements Controller{

	private BoardService boardService;
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int board_id = Integer.parseInt(request.getParameter("board_id"));
		ModelAndView mav = new ModelAndView();
		
		try {
			boardService.delete(board_id);			
			mav.setViewName("redirect:/board/list");
			
		}catch(DMLException e) {
			e.printStackTrace();
			mav.addObject("e", e);
			mav.setViewName("error/result");
		}
		return mav;
	}

}
