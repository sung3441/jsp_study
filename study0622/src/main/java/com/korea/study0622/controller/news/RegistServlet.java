package com.korea.study0622.controller.news;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.korea.study0622.model.domain.News;
import com.korea.study0622.model.news.dao.MybatisNewsDAO;
import com.korea.study0622.model.news.dao.NewsDAO;
import com.koreait.study0622.util.message.MessageObject;

public class RegistServlet extends HttpServlet{

	NewsDAO newsDAO;
	public void init(ServletConfig config) throws ServletException {
		newsDAO = new MybatisNewsDAO();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		News news = new News();
		news.setTitle(title);
		news.setWriter(writer);
		news.setContent(content);
		
		int result = newsDAO.insert(news);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(result < 1) {
			//등록 실패
			out.print(MessageObject.getMsgBack("뉴스 등록 실패"));
		}else {
			out.print(MessageObject.getMsgURL("뉴스 등록 완료", "/news/list.jsp"));
		}
	}
}









