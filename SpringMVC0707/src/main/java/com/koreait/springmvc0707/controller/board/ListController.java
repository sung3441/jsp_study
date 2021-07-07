package com.koreait.springmvc0707.controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.koreait.springmvc0707.model.board.service.BoardService;
import com.koreait.springmvc0707.model.domain.Board;

import lombok.Setter;

//게시판 목록 요청을 처리하는 하위 컨트롤러
@Setter
public class ListController implements Controller{
	
	//스프링으로부터 주입 받자!
	private BoardService boardService;
	
	//3단계, 4단계
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//3단계 일시키기
		List<Board> boardList = boardService.selectAll();
		
		//4단계 결과 저장
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", boardList);
		mav.setViewName("board/list"); //해석자가 이 부분을 넘겨받아 실제 jsp로 해석!
		
		return mav;
	}
}
