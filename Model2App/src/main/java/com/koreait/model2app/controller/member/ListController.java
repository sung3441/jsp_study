package com.koreait.model2app.controller.member;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.model2app.controller.Controller;
import com.koreait.model2app.model.member.dao.JdbcMemberDAO;
import com.koreait.model2app.model.member.dao.MemberDAO;

public class ListController implements Controller{

	MemberDAO memberDAO;
	
	public ListController() {
		memberDAO = new JdbcMemberDAO();
	}
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		
		
	}

	public String getViewName() {
		return "/result/member/list";
	}


	public boolean isForward() {
		return true;
	}

}
