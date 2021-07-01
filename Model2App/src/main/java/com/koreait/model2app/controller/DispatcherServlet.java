package com.koreait.model2app.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//웹 클라이언트의 모든 ~ 요청을 받응 유일한 진입점 서블릿이다.
//1단계 2, 5단계 처리
//1.요청받기 2.요청을 분석 3.
public class DispatcherServlet extends HttpServlet{
	
	Properties props;
	FileReader reader;
	Controller controller;
	
	public void init(ServletConfig config) throws ServletException {
		props = new Properties();
		
		try {
			ServletContext context = config.getServletContext();
			String realPath = context.getRealPath(config.getInitParameter("contextConfigLocation"));
			reader = new FileReader(realPath);
			props.load(reader);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequests(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequests(request, response);
	}
	
	protected void doRequests(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//하위 컨트롤러에게 request, response 객체를 전달하기 전에 공통적인 기능을 처리해줘야
		//코드의 중복을 피할 수 있다.
		request.setCharacterEncoding("utf-8");
	
		//2단계 요청을 분석
		String uri = request.getRequestURI();
		
		//if문 대신, props파일을 탐색하기
		//이렇게 매 요청마다 처리할 로직을 전담 객체를 1:1 부여하는 방식을 가리켜
		//command pattern이라 한다.
		String className = props.getProperty(uri);
		System.out.println(uri+" 요청에 동적할 클래스명"+className);

		//클래스 이름을 이용하여 클래스 Load하기!!
		try {
			Class controllerClass = Class.forName(className);
			
			//파일에 명시된 클래스명을 이용하여, 동적으로 인스턴스를 생성하는 방법==팩토리 패턴
			controller = (Controller) controllerClass.newInstance();
			controller.execute(request, response);
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//5단계 : 응답정보를 이용한 응답처리
		//결과는 MVC 중 view를 담당하므로, 현재 파일과는 다른 jsp에서 처리
		String viewName = controller.getViewName();
		String viewPage = props.getProperty(viewName);
		
		if(controller.isForward()) {
			//포워딩일 경우
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}else {
			//다시 재접속을 명령하는 경우 redirect == location.href
			response.sendRedirect(viewPage);
		}
	}
	//서블릿의 생명주기 메서드 중, 서블릿 소멸 시 호출 되는 destroy() 재정의
	public void destroy() {
		if(reader != null) {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}










