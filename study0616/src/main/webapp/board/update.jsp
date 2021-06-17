<%@page import="study0616.model.domain.Board"%>
<%@page import="study0616.board.model.dao.BoardDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%!
	BoardDAO boardDAO = new BoardDAO();
%>
<%
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String content = request.getParameter("content");
	String board_id = request.getParameter("board_id");
	Board board = new Board();
	
	board.setTitle(title);
	board.setWriter(writer);
	board.setContent(content);
	board.setBoard_id(Integer.parseInt(board_id));
	
	
	int result = boardDAO.update(board);
	out.print("<script>");
	if(result < 1){
		out.print("alert('값 수정 실패');");
		out.print("history.back();");
	}else{
		out.print("alert('값 수정 성공');");
		out.print("location.href = '/board/detail.jsp?board_id="+board.getBoard_id()+"';");
	}
	out.print("</script>");
%>