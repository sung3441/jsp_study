package com.korea.study0622.controller.news;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.korea.study0622.model.news.dao.MybatisNewsDAO;
import com.korea.study0622.model.news.dao.NewsDAO;
import com.koreait.study0622.util.message.MessageObject;

public class DeleteServlet extends HttpServlet{

	NewsDAO newsDAO;
	public void init(ServletConfig config) throws ServletException {
		newsDAO = new MybatisNewsDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int news_id = Integer.parseInt(request.getParameter("news_id"));
		int result =newsDAO.delete(news_id);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(result < 1) {
			out.print(MessageObject.getMsgBack("삭제실패"));
		}else {
			out.print(MessageObject.getMsgURL("삭제 완료", "/news/list.jsp"));
		}
	}
}











