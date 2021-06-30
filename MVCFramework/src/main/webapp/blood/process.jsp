<%@page import="com.koreait.mvcframework.model.blood.BloodService"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%!
	BloodService bloodService = new BloodService();
%>
<%
	//클라이언트가 전송한 파라미터를 받아 결과 보여주기
	//요청을 받아서, 적절한 로직 객체에게 일을 시키고, 적절한 결과 페이지를 보여줄 흐름처리
	
	request.setCharacterEncoding("utf-8");
	String blood = request.getParameter("blood");
	//이미 기존에 작성 해두었던 로직을 재사용!!
	response.setContentType("text/html;charset=utf-8");
	String msg = bloodService.getAdvice(blood);
		
	request.setAttribute("msg", msg); //request객체는 사실 Map 객체이다.
	//아래와 같이 요청을 끊고, 클라이언트가 재접속하게 하지 말고
	//서버에서 특정 자원으로 요청을 포워딩 즉, 전달시켜보자
	//response.sendRedirect("/blood/result.jsp"); //지정한 url을 재요청

	//포워딩 객체(전달 객체)
	RequestDispatcher dispatcher = request.getRequestDispatcher("/blood/result.jsp");
	dispatcher.forward(request, response);//쌍방울을 가지고, result.jsp로 전달된다.
	
	
%>