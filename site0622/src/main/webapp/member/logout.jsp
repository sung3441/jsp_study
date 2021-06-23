<%@ page contentType="text/html; charset=UTF-8"%>
<%
	//현재 클라이언트가 사용중인 session객체를 무효화 시키자
	session.invalidate();

%>
<script type="text/javascript">
	alert("로그아웃 처리 되었습니다.");
	location.href = "/member/login.jsp";
</script>