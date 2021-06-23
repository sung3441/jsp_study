<%@page import="com.koreait.site0622.util.message.MessageObject"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
//세션이 없다면 접근 막기
	if(session.getAttribute("member") == null){
		out.print(MessageObject.getMsgURL("로그인이 필요합니다.", "/member/login.jsp"));
	}else{		
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
  background-color: #04AA6D;
  color: white;
}
</style>
</head>
<body>

댓글을 관리하는 모드
</body>
</html>
<%}%>