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
public class RegistController implements Controller{

	private BoardService boardService;
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Board board = new Board();
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		
		ModelAndView mav = new ModelAndView();
		
		try {			
			boardService.insert(board);
			//성공의 메시지, 페이지를 보여주기
			System.out.println("등록 성공");
			mav.setViewName("redirect:/board/list");
		}catch(DMLException e) {
			//실패의 에러 페이지 보여주기
			e.printStackTrace();
			System.out.println("등록시 에러 발생");
			mav.addObject("e", e); //에러객체 담기
			mav.setViewName("error/result");
		}
		
		return mav;
	}

}
