package com.koreait.model2app.controller.board;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.model2app.controller.Controller;
import com.koreait.model2app.model.board.dao.BoardDAO;
import com.koreait.model2app.model.board.dao.JdbcBoardDAO;
import com.koreait.model2app.model.board.dao.MybatisBoardDAO;
import com.koreait.model2app.model.domain.Board;

public class RegistController implements Controller{

	BoardDAO boardDAO;
	
	public RegistController() {
		boardDAO = new MybatisBoardDAO();
	}
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		Board board = new Board();
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		
		boardDAO.insert(board);
		
	}

	@Override
	public String getViewName() {
		// TODO Auto-generated method stub
		return "/result/board/regist";
	}

	@Override
	public boolean isForward() {
		// TODO Auto-generated method stub
		return false;
	}
}
