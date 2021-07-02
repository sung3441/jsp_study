package com.koreait.model2app.controller.board;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.model2app.controller.Controller;
import com.koreait.model2app.model.board.dao.BoardDAO;
import com.koreait.model2app.model.board.dao.JdbcBoardDAO;
import com.koreait.model2app.model.board.dao.MybatisBoardDAO;
import com.koreait.model2app.model.domain.Board;

public class ListController implements Controller{

	BoardDAO boardDAO;
	
	public ListController() {
		boardDAO = new MybatisBoardDAO();
		
	}
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		
		List<Board> list = boardDAO.selectAll();
		request.setAttribute("boardList", list);
		
	}

	public String getViewName() {
		return "/result/board/list";
	}

	@Override
	public boolean isForward() {
		// TODO Auto-generated method stub
		return true;
	}
}
