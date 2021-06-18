<%@page import="site0617.model.domain.Gallery"%>
<%@page import="site0617.model.gallery.dao.GalleryDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!
	GalleryDAO galleryDAO = new GalleryDAO();
%>
<%
	Gallery gallery = galleryDAO.select(Integer.parseInt(request.getParameter("gallery_id")));
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
	 
	$($("input[type='button']")[0]).click(function () {
		edit();
	});
	
	$($("input[type='button']")[1]).click(function () {
		del();
	});
	
	$($("input[type='button']")[2]).click(function () {
		location.href = "/gallery/list.jsp";
	});
});

//클라이언트가 서버에 문자열이 아닌 파일 자체를 전송하려면 반드시
//form 태그에 mutipart/form-data가 명시되어야 한다.
//이때, 서버에서는 기존의 request 객체가 보유한 getParameter은
//바이너리 파일이 포함된 요청을 처리할 수 없다.
function del(){
	if(confirm("삭제하시겠어요?")){
		$("form").attr({
			"action" : "/delete",
			"method" : "post"
		});
		$("form").submit();
	}
}

function edit(){
	if(confirm("수정하시겠습니까?")){
		
		
	}
}


</script>
</head>
<body>

<h3>파일 업로드 양식</h3>

<div class="container">
  <form>
    <input type="hidden"	name="gallery_id" value="<%=gallery.getGallery_id()%>">
    <input type="hidden"	name="filename" value="<%=gallery.getFilename()%>">
    <input type="text"  	name="title" value="<%= gallery.getTitle()%>">
    <input type="text"  	name="writer" value="<%= gallery.getWriter()%>">
    <textarea 					name="content" style="height:200px">
    	<%= gallery.getContent() %>
    </textarea>
    <input type="file" name = "myfile"><p>    
    <input type="button" value="수정">
    <input type="button" value="삭제">
    <input type="button" value="목록">
  </form>
</div>

</body>
</html>