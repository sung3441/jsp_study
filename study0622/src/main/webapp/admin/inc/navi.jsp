<%@page import="com.korea.study0622.model.domain.Member"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	Member member = (Member) session.getAttribute("member");
%>
지금 로그인한 당신의 이름은 : <%=member.getName()%>