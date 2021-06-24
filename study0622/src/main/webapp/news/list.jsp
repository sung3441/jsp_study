<%@page import="com.korea.study0622.model.domain.News"%>
<%@page import="java.util.List"%>
<%@page import="com.korea.study0622.model.news.dao.MybatisNewsDAO"%>
<%@page import="com.korea.study0622.model.news.dao.NewsDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%!
	NewsDAO newsDAO = new MybatisNewsDAO();
%>
<%
	List<News> list = newsDAO.selectAll(); 
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<style>
table {
  border-collapse: collapse;
  border-spacing: 0;
  width: 100%;
  border: 1px solid #ddd;
}

th, td {
  text-align: left;
  padding: 16px;
}

tr:nth-child(even) {
  background-color: #f2f2f2;
}
</style>
</head>
<body>
<h3>뉴스 목록</h3>
<table>
 	<tr>
	    <th>NO</th>
	    <th>제목</th>
	    <th>이름</th>
	    <th>작성일</th>
	    <th>조회 수</th>
 	</tr>
 	<%for(News news : list){ %>
	 	<tr>
		    <td><%= news.getNews_id() %></td>
		    <td><a href = "/news/detail.jsp?news_id=<%= news.getNews_id() %>"><%= news.getTitle() %></a></td>
		    <td><%= news.getWriter() %></td>
		    <td><%= news.getRegdate() %></td>
		    <td><%= news.getHit() %></td>
		</tr>
	<%} %>
	 <tr>
	 	<td colspan = "5">
	 		<button onclick = "location.href='/news/regist.jsp'">뉴스 등록</button>
	 	</td>
	 </tr>
</table>

</body>
</html>
