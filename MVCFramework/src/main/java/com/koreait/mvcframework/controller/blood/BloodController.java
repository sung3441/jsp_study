package com.koreait.mvcframework.controller.blood;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.mvcframework.controller.Controller;
import com.koreait.mvcframework.model.blood.BloodService;

//혈액형 요청을 처리하는 컨트롤러 클래스
public class BloodController implements Controller{

	BloodService bloodService;
	
	public BloodController() {
		bloodService = new BloodService();
	}
	
	public void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String blood = request.getParameter("blood");
		//이미 기존에 작성 해두었던 로직을 재사용!!
		String msg = bloodService.getAdvice(blood);
		//요청객체에 데이터 저장
		request.setAttribute("msg", msg); //request객체는 사실 Map 객체이다.
		//아래와 같이 요청을 끊고, 클라이언트가 재접속하게 하지 말고
		//서버에서 특정 자원으로 요청을 포워딩 즉, 전달시켜보자
		//response.sendRedirect("/blood/result.jsp"); //지정한 url을 재요청
	}
	
	@Override
	public String getViewName() {
		// TODO Auto-generated method stub
		return "/blood/result.jsp";
	}
}