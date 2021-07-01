package com.koreait.model2app.controller.board;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.model2app.controller.Controller;
import com.koreait.model2app.model.board.dao.BoardDAO;
import com.koreait.model2app.model.board.dao.JdbcBoardDAO;
import com.koreait.model2app.model.board.dao.MybatisBoardDAO;
import com.koreait.model2app.model.domain.Board;

public class DetailController implements Controller{

	BoardDAO boardDAO; 
	
	public DetailController() {
		boardDAO = new JdbcBoardDAO();
	}
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		int board_id = Integer.parseInt(request.getParameter("board_id"));
		Board board = boardDAO.select(board_id);
		
		request.setAttribute("board", board);
	}

	public String getViewName() {
		return "/result/board/detail";
	}

	public boolean isForward() {
		return true;
	}

	
}
