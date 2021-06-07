<%@ page contentType="text/html;charset=UTF-8"%>

<%
/*
jsp란?
-java server page : 자바 기술로 오직 서버에서만 실행되는 파일
결론 : 우리가 알고 있는 javaSE에 사용했던 문법이 그래도 사용될 수 있다.

-jsp파일의 작성 영역(총 4가지 영역을 갖는다.)

1)지시영역(필수) - 현재 페이지에 대한 정보 및 설정, 응답 시 Head정보를 구성

2)선언부(선택) - 
3)스크립틀릿(필수) - [% 영역 %]
						-로직을 작성하는 영역, 메서드 영역임
4)표현식(선택)

*/
	//node.js에서의 response.end( ) 응답정보 전송
	out.print("이것은 나의 my jsp");
%>