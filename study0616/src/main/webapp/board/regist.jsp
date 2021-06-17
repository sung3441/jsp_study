<%@ page contentType="text/html; charset=UTF-8"%>
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
	
	$("#bt").click(function(){
		regist();
	});
});

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
			<input type="text" name="title" placeholder="제목..">
			<input type="text" name="writer" placeholder="이름..">
			<textarea name="content" placeholder="내용.." style="height:200px"></textarea>
			<input type="button" id = "bt" value="등록">
		</form>
	</div>
</body>
</html>
