<%@page import="study0616.model.domain.Board"%>
<%@ page import="study0616.board.model.dao.BoardDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%!
	BoardDAO boardDAO = new BoardDAO();
%>
<%
	String board_id = request.getParameter("board_id");
	Board board = boardDAO.select(Integer.parseInt(board_id));
%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}
input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
}

input[type=button] {
  background-color: #04AA6D;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=button]:hover {
  background-color: #45a049;
}

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.ckeditor.com/4.16.1/standard/ckeditor.js"></script>
<script>

$(function(){
	//텍스트 편집기
	CKEDITOR.replace("content");
	
	$("#bt1").click(function(){
		edit();
	});
	
	$("#bt2").click(function(){
		del();
	});
	
	$("#bt3").click(function(){
		location.href = "/board/list.jsp";
	});
});


function edit()	{
	$("form").attr({
		"action" : "/board/update.jsp",
		"method" : "post"
	});
	$("form").submit();
}

function del(){
	$("form").attr({
		"action" : "/board/delete.jsp",
		"method" : "post"
	});
	$("form").submit();
}

//글 등록 함수
function regist(){
	//전송할 때 정보들을 설정
	$("form").attr({
		"action" : "/board/regist_db.jsp",
		"method" : "post"
	});
	$("form").submit(); //전송
}

</script>
</head>
<body>

	<h3>게시물 등록</h3>

	<div class="container">
		<form>
			<input type="text" name="title" value = "<%=board.getTitle()%>">
			<input type="text" name="writer" value = "<%= board.getWriter()%>">
			<input type="hidden" name="board_id" value = "<%= board.getBoard_id()%>">
			<textarea name="content" style="height:200px">
				<%=board.getContent() %>
			</textarea>
			<input type="button" id = "bt1" value="수정">
			<input type="button" id = "bt2" value="삭제">
			<input type="button" id = "bt3" value="목록">
		</form>
	</div>
</body>
</html>