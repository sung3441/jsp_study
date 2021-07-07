package com.koreait.springmvc0707.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.koreait.springmvc0707.model.board.service.BoardService;
import com.koreait.springmvc0707.model.domain.Board;

import lombok.Setter;

//수정 요청을 처리하는 하위 컨트롤ㄹ러
@Setter
public class UpdateController implements Controller{

	private BoardService boardService;
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Board board = new Board();
		
		int board_id = Integer.parseInt(request.getParameter("board_id"));
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		board.setBoard_id(board_id);
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		
		//3단계 일 시키기
		//boardService.update(board);
		
		//4단계 결과를 저장하지 않고 redirect로 다시 접속 유도 하기
		ModelAndView mav = new ModelAndView();
		//redirect: 을 적용하면 forwarding이 아닌 redirect!
		mav.setViewName("redirect:/board/detail?board_id="+board_id); 
		return mav;
	}
}
