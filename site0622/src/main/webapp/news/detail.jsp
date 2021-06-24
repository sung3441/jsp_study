<%@page import="com.koreait.site0622.model.domain.Comments"%>
<%@page import="com.koreait.site0622.model.comments.dao.MybatisCommentsDAO"%>
<%@page import="com.koreait.site0622.model.comments.dao.CommentsDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.koreait.site0622.model.domain.News"%>
<%@page import="com.koreait.site0622.model.news.dao.MybatisNewsDAO"%>
<%@page import="com.koreait.site0622.model.news.dao.NewsDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%!
	NewsDAO newsDAO = new MybatisNewsDAO();
	CommentsDAO commentsDAO = new MybatisCommentsDAO();
%>
<%
	int news_id = Integer.parseInt(request.getParameter("news_id"));
	News news = newsDAO.select(news_id);
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
	print 
	
	$($("input[type='button']")[0]).click(function () {
		edit();
	});
	$($("input[type='button']")[1]).click(function () {
		del();
	});
	$($("input[type='button']")[2]).click(function () {
		location.href = "/news/list.jsp";
	});
	$("#bt_comments_regist").click(function () {
		registComment();
	});
	
	getCommentsList();
});

//글 등록
function edit(){
	$("#newsform").attr({
		"action" : "",
		"method" : "post"
	});
	$("#newsform").submit();
}

//글 삭제
function del(){
	$("#newsform").attr({
		"action" : "",
		"method" : "post"
	});
	$("#newsform").submit();
}

//댓글 등록
function registComment(){
	//폼 양식을 전송할 수 있는 문자열로 반환
	var formdata = $("#commentsform").serialize(); 
	$.ajax({
		"url" : "/comments/regist",
		"type" : "post",
		"data" : formdata,
		"success" : function(result, status, xhr){
			if(result == 1){
				//현재 뉴스 기사에 딸린 댓글 가져오기
				getCommentsList();
			}
		},
		"error" : function(xhr, status, error){
				
		}
	});
}

function getCommentsList(){
	$.ajax({
		"url" : "/comments/list?news_id=<%=news.getNews_id()%>",
		"type" : "get",
		"success" : function(result, status, xhr){
			
			//넘겨받은 데이터가 String일 경우 json으로 파싱하자
			//var json = JSON.parse(result);
			printCommentsList(result);
		},
		"error" : function(xhr, status, error){
			
			
		}
	});
	
}

// 방법1) 댓글 목록 출력하기
function printCommentsList(json){
	//기존의  commentsArea 의 컨텐츠를 초기화!(div 화면에서 제거)
	$("#commentsArea").html("");
	var tag = "";
	
	for(var i = 0; i < json.commentsList.length; i++){
		var comments = json.commentsList[i]; //댓글하나 꺼내기
		tag += "<div>";
		tag += "<input type=\"text\" value=\""+comments.msg+"\" style=\"width: 60%\" readonly=\"readonly\">";
		tag += "<input type=\"text\" value=\""+comments.cwriter+"\" style=\"width: 20%\" readonly=\"readonly\">";
		tag += "<input type=\"text\" value=\""+comments.cdate+"\" style=\"width: 10%\" readonly=\"readonly\">";
		tag += "</div>";
	}
	/*
	var commentsArea = document.getElementById("commentsArea");
	commentsArea.innerHTML = tag;
	*/
	
	//jquery
	$("#commentsArea").append(tag);
}

// 방법2) 출력 대상이 되는 태그를 객체로 처리하는 방법
function printCommentsList2(){
	
	
	
}

</script>
</head>
<body>

<h3>News 상세보기</h3>

<div class="container">
  <form id="newsform">
    <input type="hidden"  	name="news_id" value="<%= news.getNews_id() %>">
    <input type="text"  	name="title" value="<%= news.getTitle() %>">
    <input type="text"  	name="writer" value="<%=news.getWriter()%>">
    <textarea 					name="content" style="height:200px">
    	<%=news.getContent() %>
    </textarea>
    <input type="button" value="수정">
    <input type="button" value="삭제">
    <input type="button" value="목록">
  </form>
</div>
<form id="commentsform">
	<div>
	<input type="hidden"  	name="news_id" value="<%= news.getNews_id() %>">
		<input type="text" name="msg" placeholder="댓글 메시지.." style="width: 60%">
		<input type="text" name="cwriter" placeholder="작성자.." style="width: 20%">
		<input type="button" value="댓글등록" id="bt_comments_regist" style="width: 10%">
	</div>
</form>
<div id="commentsArea">
	여기에 댓글 div들이 동적으로 증가될 영역
	
</div>
</body>
</html>




















