package com.koreait.site0622.controller.comments;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.site0622.model.comments.dao.CommentsDAO;
import com.koreait.site0622.model.comments.dao.JdbcCommentsDAO;
import com.koreait.site0622.model.comments.dao.MybatisCommentsDAO;
import com.koreait.site0622.model.domain.Comments;

public class ListServlet extends HttpServlet{

	CommentsDAO commentsDAO;
	public void init(ServletConfig config) throws ServletException {
		commentsDAO = new JdbcCommentsDAO();
		//commentsDAO = new MybatisCommentsDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int news_id = Integer.parseInt(request.getParameter("news_id"));
	
		List<Comments> commentsList = commentsDAO.selectByNewsId(news_id);
	
		//보낼 때 contentType을 json 형식으로 보내면 클라이언트는
		//파싱할 필요조차 없다.
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		StringBuilder sb=new StringBuilder();

		sb.append("{");
		sb.append("\"commentsList\":[");
		
		for(int i = 0; i < commentsList.size(); i++) {
			Comments comments = commentsList.get(i);
			sb.append("{");
			sb.append("\"comments_id\":"+comments.getComments_id()+",");
			sb.append("\"msg\":\""+comments.getMsg()+"\",");
			sb.append("\"cwriter\":\""+comments.getCwriter()+"\",");
			sb.append("\"cdate\":\""+comments.getCdate()+"\",");
			sb.append("\"news_id\":"+comments.getNews_id());
			if(i < commentsList.size()-1) {
				sb.append("},");				
			}else {
				sb.append("}");
			}
		}
		
		sb.append("]");
		sb.append("}");

		out.print(sb.toString()); //클라이언트에 보낼 응답 컨텐츠 구성
	}
}
















