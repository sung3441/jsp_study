package com.koreait.site0625.controller.reboard;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.site0625.model.domain.ReBoard;
import com.koreait.site0625.model.reboard.dao.MybatisReboardDAO;
import com.koreait.site0625.model.reboard.dao.ReBoardDAO;
import com.koreait.site0625.util.message.MessageObject;

public class RegistServlet extends HttpServlet{

	ReBoardDAO boardDAO ;
	public void init() throws ServletException {
		boardDAO = new MybatisReboardDAO();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		ReBoard reBoard = new ReBoard();
		reBoard.setTitle(title);
		reBoard.setWriter(writer);
		reBoard.setContent(content);
		
		int result = boardDAO.insert(reBoard);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(result < 1) {
			out.print(MessageObject.getMsgBack("글 등록 실패"));
		}else {
			out.print(MessageObject.getMsgURL("글 등록 완료", "/reboard/list.jsp"));		
		}
	}
}
