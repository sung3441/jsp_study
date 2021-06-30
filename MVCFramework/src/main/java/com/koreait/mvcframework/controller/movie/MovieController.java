package com.koreait.mvcframework.controller.movie;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.mvcframework.controller.Controller;
import com.koreait.mvcframework.model.movie.MovieService;

public class MovieController implements Controller{

	MovieService movieService;
	
	public MovieController() {
		movieService = new MovieService();
	}
	
	public void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String movie = request.getParameter("movie"); //파라미터 받기
		String msg = movieService.getAdvice(movie);
		request.setAttribute("msg", msg);
	}
	
	@Override
	public String getViewName() {
		// TODO Auto-generated method stub
		return "/movie/result.jsp";
	}
}
