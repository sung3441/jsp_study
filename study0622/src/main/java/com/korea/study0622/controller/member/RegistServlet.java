package com.korea.study0622.controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.korea.study0622.model.domain.Member;
import com.korea.study0622.model.member.dao.MemberDAO;
import com.korea.study0622.model.member.dao.MybatisMemberDAO;
import com.koreait.study0622.util.message.MessageObject;

public class RegistServlet extends HttpServlet{
	
	MemberDAO memberDAO;
	public void init(ServletConfig config) throws ServletException {
		memberDAO = new MybatisMemberDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String user_id = request.getParameter("user_id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		
		Member member = new Member();
		member.setUser_id(user_id);
		member.setPassword(password);
		member.setName(name);
		
		int result = memberDAO.regist(member);
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		if(result < 1) {
			out.print(MessageObject.getMsgBack("회원가입 실패"));
		}else {
			out.print(MessageObject.getMsgURL("회원가입 성공", "/member/login.jsp"));
		}
	}
}
