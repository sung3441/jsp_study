package com.koreait.site0622.controller.comments;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.ObjectInputFilter.Config;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.site0622.model.comments.dao.CommentsDAO;
import com.koreait.site0622.model.comments.dao.JdbcCommentsDAO;
import com.koreait.site0622.model.comments.dao.MybatisCommentsDAO;
import com.koreait.site0622.model.domain.Comments;

//댓글 등록 요청 처리 서블릿(클라이언트의 요청이 비동기 방식이므로 , 디자인을 결과로
//보내서는 안됨 처리결과만..) 왜? 전체 새로고침이 일어나지 않는 방식이라 디자인을
//보낼 의미가 없음, 즉 전체 페이지 변환이 목적이 아니라 , 페이지의 일부 변경이 목적
public class RegistServlet extends HttpServlet{

	CommentsDAO commentsDAO;
	public void init(ServletConfig config) throws ServletException {
		//commentsDAO = new JdbcCommentsDAO();
		commentsDAO = new MybatisCommentsDAO();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String msg = request.getParameter("msg");
		String cwriter = request.getParameter("cwriter");
		String news_id = request.getParameter("news_id");
		
		Comments comments = new Comments();
		comments.setMsg(msg);
		comments.setCwriter(cwriter);
		comments.setNews_id(Integer.parseInt(news_id));
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		int result = commentsDAO.insert(comments);
		out.print(result);
	}
}
