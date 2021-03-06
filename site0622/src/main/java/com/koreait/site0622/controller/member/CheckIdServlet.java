package com.koreait.site0622.controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.site0622.model.domain.Member;
import com.koreait.site0622.model.member.dao.MemberDAO;
import com.koreait.site0622.model.member.dao.MybatisMemberDAO;

//아이디 중복체크 여부 확인 서블릿
public class CheckIdServlet extends HttpServlet{
	MemberDAO memberDAO ;
	
	public void init() throws ServletException {
		memberDAO = new MybatisMemberDAO();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 넘겨받아, member테이블에 이미 존재하는지 여부를 체크
		String user_id = request.getParameter("user_id");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Member member = memberDAO.getMemberById(user_id);
		/*
		 * if(member == null) { //동기방식 일 떄 적절한 응답 정보
		 * //out.print(MessageObject.getMsgURL("사용 가능한 아이디입니다.", "/member/signup.jsp"));
		 * }else { //동기방식 일 떄 적절한 응답 정보
		 * out.print(MessageObject.getMsgBack("이미 사용 중인 ID입니다.")); }
		 */
		
		//비동기에 적절한 응답 보내기
		if(member == null) {
			out.print(0);
		}else {
			out.print(1);
		}
	}
}
