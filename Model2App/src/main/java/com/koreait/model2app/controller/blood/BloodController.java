package com.koreait.model2app.controller.blood;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.model2app.controller.Controller;
import com.koreait.model2app.model.blood.BloodService;

public class BloodController implements Controller{
	BloodService service;
	
	public BloodController() {
		service = new BloodService();
	}
	
	//혈액형애 대한 판단을 처리
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		//3단계 : 알맞는 로직 객체를 일 시키기
		String blood = request.getParameter("blood");
		String msg = service.getAdvice(blood);
		
		//4단계 : 결과가 있다면 결과를 저장한다.
		request.setAttribute("msg", msg); //아직 응답이 처리되지 않은 시점이므로 동생과 형이
		//공유하고 있는request 객체에 데이터를 넣어두자 이렇게 하면 형님이 이 데이터를 꺼낼 수 있다.
		
		
	}

	public String getViewName() {
		return "/blood/result";
	}

	@Override
	public boolean isForward() {
		// TODO Auto-generated method stub
		return false;
	}

}
