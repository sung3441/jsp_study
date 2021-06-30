package com.koreait.mvcframework.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//모든 하위 컨트롤러의 부모인 인터페이스
public interface Controller {
	public void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

	//
	public String getViewName();
}