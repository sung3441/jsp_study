package com.koreait.model2app.controller.movie;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.model2app.controller.Controller;
import com.koreait.model2app.model.movie.MovieService;

public class MovieController implements Controller{

	MovieService service;
	
	public MovieController() {
		service = new MovieService();
	}
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		String msg = service.getAdvice(request.getParameter("movie"));
		request.setAttribute("msg", msg);
	}

	public String getViewName() {
		return "/movie/result";
	}

	@Override
	public boolean isForward() {
		// TODO Auto-generated method stub
		return false;
	}

}
