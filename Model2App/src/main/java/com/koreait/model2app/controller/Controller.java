package com.koreait.model2app.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException;
	public String getViewName(); //응답 시 보여질 결과 페이지
	public boolean isForward(); //포워딩 필요 여부를 반환해주는 메서드
}
