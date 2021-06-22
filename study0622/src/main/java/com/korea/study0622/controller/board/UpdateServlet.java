package com.korea.study0622.controller.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.korea.study0622.model.board.dao.BoardDAO;
import com.korea.study0622.model.board.dao.MybatisBoardDAO;
import com.korea.study0622.model.domain.Board;
import com.koreait.study0622.util.message.MessageObject;

public class UpdateServlet extends HttpServlet{

	BoardDAO boardDAO;
	public void init(ServletConfig config) throws ServletException {
	
		boardDAO = new MybatisBoardDAO();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//파라미터 받기
		request.setCharacterEncoding("utf-8"); //한글 안깨지게
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		String board_id = request.getParameter("board_id");
		
		Board board = new Board();
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		board.setBoard_id(Integer.parseInt(board_id));
		
		int result = boardDAO.update(board);
		if(result < 1) {
			out.print(MessageObject.getMsgBack("수정 실패요"));
		}else {
			out.print(MessageObject.getMsgURL("수정 성공", "/board/detail.jsp?board_id="+board_id));
		}
	}
}











