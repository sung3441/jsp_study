<%@page import="com.koreait.site0622.model.domain.Board"%>
<%@page import="com.koreait.site0622.model.board.dao.MybatisBoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	MybatisBoardDAO boardDAO = new MybatisBoardDAO();
 %>
<%
	String board_id = request.getParameter("board_id");
	Board board = boardDAO.select(Integer.parseInt(board_id)); //레코드 한건 가져오기
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset = "utf-8">
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
<script type="text/javascript">
//초기화
$(function(){
	 CKEDITOR.replace( "content" );
	 //수정 버튼
	 $($("input[type='button']")[0]).click(function(){
		 if(confirm("수정하시겠습니까?")){
			 edit();
		 } 
	 });
	 //삭제 버튼
	 $($("input[type='button']")[1]).click(function(){
	 	 if(confirm("삭제하시겠습니까?")){
	 		 del();
	 	 }
	 });
	 //목록 버튼
	 $($("input[type='button']")[2]).click(function(){
		 location.href = '/board/list.jsp';
	 });
});

function edit(){
	$("form").attr({
		"action" : "/board/edit",
		"method" : "post"
	});
	$("form").submit();
}

function del(){
	$("form").attr({
		"action" : "/board/delete",
		"method" : "post"
	});
	$("form").submit();
}

</script>
</head>
<body>

<h3>상세보기</h3>

<div class="container">
  <form>
    <input type="text"  	name="title" value = <%= board.getTitle() %>>
    <input type="text"  	name="writer" value = <%= board.getWriter() %>>
    <textarea	name="content" style="height:200px">
    	<%= board.getContent() %>
    </textarea>
    <input type = "hidden" name = "board_id" value = <%= board.getBoard_id() %>>
    <input type="button" value="수정">
    <input type="button" value="삭제">
    <input type="button" value="목록">
  </form>
</div>
</body>
</html>