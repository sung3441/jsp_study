<%@page import="com.koreait.site0622.model.board.dao.BoardDAO"%>
<%@page import="com.koreait.site0622.model.board.dao.JdbcBoardDAO"%>
<%@page import="com.koreait.site0622.model.domain.Board"%>
<%@page import="com.koreait.site0622.model.board.dao.MybatisBoardDAO"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%!BoardDAO boardDAO = new MybatisBoardDAO();%>
<%
	List<Board> list = boardDAO.selectAll();

	int totalRecord = list.size(); //총게시물 수
	int pageSize = 10; //한 페이지에 보여질 게시물의 수
	int totalPage = (int)Math.ceil((float)totalRecord/pageSize); //총 페이지 수(나머지 숨겨진 데이터를 보기 위한 페이지 분할된 총 수)
	int blockSize = 10;
	
	int currentPage = 1; //현재 페이지
	//단, 사용자가 아래의 페이지 링크를 눌러 currentPage 파라미터 값을 넘길 경우 그 넘어온 값을
	//우선 해야 한다.
	if(request.getParameter("currentPage") != null){
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
	}
	
	int firstPage = currentPage - ((currentPage-1) % blockSize);
	int lastPage = firstPage + (blockSize-1);
	int curPos = (currentPage-1) * pageSize;
	int num = totalRecord - curPos;
%>

<%= "당신이 보고 있는 페이지는 "+currentPage+"<br>" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset = "utf-8">
<style>
table {
  border-collapse: collapse;
  border-spacing: 0;
  width: 100%;
  border: 1px solid #ddd;
  position : relative;
}

th, td {
  text-align: left;
  padding: 16px;
}

tr:nth-child(even) {
  background-color: #f2f2f2;
}

/* 나만의 페이지 번호 스타일 정의 */
.pageNum{
	font-weight: bold;
	font-size: 20px;
	color: red;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function () {
	$("#regist_bt").click(function(){
		location.href = "/board/regist.jsp";
		
	});
});

</script>
</head>
<body>
<h2>게시판 목록</h2>
<table>
	<tr>
		<th>No</th>
		<th>제목</th>
		<th>작성자</th>
		<th>등록일</th>
		<th>조회수</th>
	</tr>
	<%for(int i = 1; i <= pageSize; i++){ %>
	<%if(num < 1) break; %>
	<%Board board = list.get(curPos++); %>
	<tr>
		<td><%= num-- %></td>
		<td><a href = "/board/detail.jsp?board_id=<%=board.getBoard_id()%>"><%= board.getTitle() %></a></td>
		<td><%= board.getWriter() %></td>
		<td><%= board.getRegdate() %></td>
		<td><%= board.getHit() %></td>
	</tr>
	<% }%>
	<tr>
		<td colspan='5' style = "text-align : center">
			<a href = "/board/list.jsp?currentPage=<%=firstPage-1%>">◀</a>
			<%for(int i = firstPage; i <= lastPage; i++){ %>
				<%if(i > totalPage) break; //i가 총 페이지 수를 넘어서면 반복문 멈추기%> 
				<a href = "/board/list.jsp?currentPage=<%=i%>" <%if (currentPage==i){%>class = "pageNum"<%} %>>[<%= i %>]</a>
			<%} %>
			<a href = "/board/list.jsp?currentPage=<%=lastPage+1%>">▶</a>
		</td>
	</tr>  
	<tr> 
		<td colspan = "5"><button id="regist_bt">글등록</button></td>
	</tr>
  
</table>
</body>
</html>
