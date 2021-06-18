package site0617.gallery;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.InitialContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import site0617.model.domain.Gallery;
import site0617.model.gallery.dao.GalleryDAO;
import site0617.util.FileManager;

//이미 jsp로도 업로드 처리가 가능하겠으나, 서블릿을 다시 한 번 공부 해보고자 작성
public class UploadServlet extends HttpServlet{

	ServletContext context;
	GalleryDAO galleryDAO;
	
	public void init(ServletConfig config) throws ServletException {
		context = config.getServletContext();
		galleryDAO = new GalleryDAO();
		
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		//@page contentType="text/html; charset=utf-8"
		
		PrintWriter out = response.getWriter();
		out.print("내가 처리함ㅋㅋ<br>"); //<%="제가 업로드 처리"%> <%out.print("")%>
		
		request.setCharacterEncoding("utf-8");
		//jsp의 request 객체의 setCharacterEncoding() 와 동일
		//아래 처럼 경로를 개발자가 직접 구할 경우 시스템에 의종적이 되므로, 이 웹 어플리케이션을
		//다른 기반의 플랫폼에서ㅜ 배포하여 실행할때 문제가 발생할 수 있다.
		//해결은 프로그래밍적으로 경로를 동적으로 얻어와서 처리하면 됨..
		String path = context.getRealPath("/data");
		//루트인 webapp을 기준으로 경로를 설정해주면 됨
		out.print(path+"<br>");
		
		//첫 번째 생성자는 파일명이 영문이 아닌 경우 깨진다.
		//MultipartRequest multi = new MultipartRequest(request, path);
		int maxSize = 2*1024*1024; //6메가
		//두 번째 생성자는 업로드 용량을 제한할 수 있다.
		
		try {
			MultipartRequest multi = new MultipartRequest(request, path, maxSize, "utf-8");
			
			File file = multi.getFile("myfile");
			long time = System.currentTimeMillis(); //test.kk.png
			String destName = time+"."+FileManager.getExt(file.getName());
			File dest = new File(path+"/"+destName); //새로 만들어질 파일 생성
			file.renameTo(dest);
			out.print("업로드에 성공했습니다.<br>");
			
			//텍스트 파라미터 받기
			String title = multi.getParameter("title");
			String writer = multi.getParameter("writer");
			String content = multi.getParameter("content");
			
			Gallery gallery = new Gallery();
			gallery.setTitle(title);
			gallery.setWriter(writer);
			gallery.setContent(content);
			gallery.setFilename(destName);
			
			int result = galleryDAO.insert(gallery);
			if(result < 1) {
				out.print("등록 실패");
			}else {
				out.print("등록 성공");
				response.sendRedirect("/gallery/list.jsp"); //지정한 url로 다시 재접속을 명령
			}
		} catch (IOException e) {
			out.print("업로드에 실패했습니다.<br>");
			e.printStackTrace(); //원인을 분석할 수 있도록 스택구조로 출력
		}
	}
}






















