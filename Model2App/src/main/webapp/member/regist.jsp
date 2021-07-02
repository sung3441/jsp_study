<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	 
	$("input[type='button']").click(function () {
		regist();
	});
	 
	$("button").click(function () {
		addText();
	});
});

//글 등록
function regist(){
	$("form").attr({
		"action" : "/member/regist.do",
		"method" : "post",
		"enctype" : "multipart/form-data"
	});
	$("form").submit();
}

//자격증 텍스트 박스 동적 추가
function addText(){
	$("#license_container").append("<input type=\"text\" name='title' placeholder=\"자격증..\" >");
	
}
</script>
</head>
<body>

<h3>회원 가입</h3>

<div class="container">
  <form>
    <input type="text"  	name="name" 	placeholder="이름..">
    <input type="text"  	name="phone" placeholder="연락처..">
    <input type="text"  	name="addr" 	placeholder="주소..">
    <input type="file"  	name="img" 	placeholder="프로필..">
    <h3>
    	자격증<button type="button">+</button>
    </h3>
    <input type="text"  	name="title" 	placeholder="자격증.." >
    <div id="license_container"></div>
    <input type="button" value="Submit">
  </form>
</div>

</body>
</html>