<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page contentType="text/html; charset=UTF-8"%>


<%
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = null;
	PreparedStatement pstmt = null;

	con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "webmaster", "1234");
	
	//클라이언트 detail.jsp로부터 4개의 파라미터를 받자
	request.setCharacterEncoding("utf-8");
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String content = request.getParameter("content");
	String board_id = request.getParameter("board_id");
	
	String sql = "update board set title = ?, writer = ?, content = ? where board_id = ?";
	pstmt = con.prepareStatement(sql);
	pstmt.setString(1, title);
	pstmt.setString(2, writer);
	pstmt.setString(3, content);
	pstmt.setInt(4, Integer.parseInt(board_id));
	
	int result = pstmt.executeUpdate();
	out.print("<script>");
	if(result > 1){
		out.print("alert('수정 실패');");
		out.print("history.back();");
	}else{
		out.print("alert('수정 성공');");
		out.print("location.href = '/board/detail.jsp?board_id="+board_id+"';");
	}
	out.print("</script>");
%>