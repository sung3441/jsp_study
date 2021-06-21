<%@ page import="javax.swing.text.Style"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	int totalRecord = 200; //총 게시물 수
	int pageSize = 10; //한 페이지에 보여질 게시물의 수
	int totalPage = (int)Math.ceil((float)totalRecord/pageSize); //총 페이지 수
	int blockSize = 10; //한 화면에 보일 버튼의 갯수

	int currentPage = 1; //현재 페이지
	if(request.getParameter("currentPage") != null){
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
	}
	
	int firstPage = currentPage - ((currentPage-1) % blockSize);
	int lastPage = firstPage + (blockSize-1);
	int num = totalRecord - (currentPage - 1) * pageSize;
%>

시작 페이지는 : <%= firstPage %>
끝 페이지는 : <%= lastPage %>
totalPage : <%= totalPage %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
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

.Num{
	color: red;
	font-size: 20px;
	font-weight: bold;
}
</style>
</head>
<body>

<h2>Zebra Striped Table</h2>
<p>For zebra-striped tables, use the nth-child() selector and add a background-color to all even (or odd) table rows:</p>

<table>
  <tr>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Points</th>
  </tr>
  <% for(int i = 1; i <= pageSize; i++){ %>
  <%if(num < 1) break; %>
  <tr>
    <th><%= num-- %></th>
    <th></th>
    <th></th>
  </tr>
  <% } %>
  <tr>
  	<td colspan="3" style = "text-align: center">
  	<%if(firstPage > 1){ %> 
		<a href = "/test/list.jsp?currentPage=<%=firstPage-1%>">◀</a>
	<%} %>
  	<%for(int i = firstPage; i <= lastPage; i++){ %>
  		<%if(i > totalPage) break; %>
  		<a href = "/test/list.jsp?currentPage=<%=i%>" <%if(currentPage == i){%> class = "Num"<%} %>>[<%=i %>] </a>
  	<%} %>
  	<%if(totalPage > lastPage){ %> 
		<a href = "/test/list.jsp?currentPage=<%=lastPage+1%>">▶</a>
  	<%} %>
  	</td>
  </tr>
</table>
</body>
</html>