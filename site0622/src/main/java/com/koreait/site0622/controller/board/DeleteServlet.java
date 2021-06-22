package com.koreait.site0622.controller.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.site0622.model.board.dao.MybatisBoardDAO;
import com.koreait.site0622.util.message.MessageObject;

public class DeleteServlet extends HttpServlet{

	MybatisBoardDAO boardDAO;
	public void init(ServletConfig config) throws ServletException {
		boardDAO = new MybatisBoardDAO();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String board_id = request.getParameter("board_id");
		int result = boardDAO.delete(Integer.parseInt(board_id));
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(result < 1) {
			out.print(MessageObject.getMsgBack("삭제 실패"));
		}else {
			out.print(MessageObject.getMsgURL("삭제 성공", "/board/list.jsp"));
		}
	}
}
