<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
select{
	width : 400px;
	font-size : 25px;
}

</style>
<script type="text/javascript">
function send(){
	form1.action="/blood.do";
	form1.method="post";
	form1.submit();
}

</script>
</head>
<body>
<form name="form1">
	<select name="blood">
		<option>자신의 혈액형을 선택하세요.</option>
		<option value="A">A형</option>
		<option value="B">B형</option>
		<option value="O">O형</option>
		<option value="AB">AB형</option>
	</select>
</form>
<button onClick="send()">결과보기</button>
</body>
</html>