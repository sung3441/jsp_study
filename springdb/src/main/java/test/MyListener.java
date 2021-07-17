package test;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import lombok.val;

//웹 서버가 가동될 때를 감지하여 원하는 메시지 심기
public class MyListener implements ServletContextListener{

	//웹 어플을 가동할 때 호출되는 메서드
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("server is running at 9999 port....");

		ServletContext servletContext = sce.getServletContext();
		String value = servletContext.getInitParameter("contextConfigLocation");
		servletContext.setAttribute("obj", value);
	}
	
	//웹 어플을 중지할 때 호출되는 메서드
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("server is stop");
	}
}
