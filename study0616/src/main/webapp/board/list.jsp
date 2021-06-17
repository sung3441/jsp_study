<%@page import="java.util.List"%>
<%@page import="study0616.model.domain.Board"%>
<%@page import="java.util.ArrayList"%>
<%@page import="study0616.board.model.dao.BoardDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%!
	BoardDAO boardDAO = new BoardDAO();
%>
<%
	ArrayList<Board> list = (ArrayList)boardDAO.selectAll();
%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
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

<h2>글 목록입니다.</h2>
<table>
	<tr>
		<th>NO</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>조회수</th>
	</tr>
	<%for(Board board : list){ %>
	<tr>
		<td><%= board.getBoard_id() %></td>
		<td><a href="/board/detail.jsp?board_id=<%=board.getBoard_id()%>"><%= board.getTitle() %></a></td>
		<td><%= board.getWriter() %></td>
		<td><%= board.getRegdate() %></td>
		<td><%= board.getHit() %></td>
	</tr>
	<%}%>
</table>
</body>
</html>