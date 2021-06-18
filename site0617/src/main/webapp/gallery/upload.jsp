<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%!
	
%>

<%
	//스클립틀릿 영역
	
	//클라이언트가 일반폼이 아닌 바이너리 데이터가 포함된 데이터를 전송할 경우
	//즉 form태그에 enctype을 multipart/form-data로 지정하여
	
	out.print("제가 업로드 처리할께열<br>");
	request.setCharacterEncoding("utf-8");
	/* String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String content = request.getParameter("content"); */

	//업로드 처리 객체인 MultipartRequest를 사용해보자
	String path = "D:/workspace/korea_jspworkspace/site0617/src/main/webapp/data";
	MultipartRequest multi = new MultipartRequest(request, path); //생성자 호출에 의해 업로드 완료
	out.print("업로드 완료");
%>