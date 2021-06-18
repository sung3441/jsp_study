package site0617.gallery;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import site0617.model.gallery.dao.GalleryDAO;

public class DeleteServlet extends HttpServlet{

	GalleryDAO galleryDAO;
	ServletContext context; //현재 서블릿이 실행되고 있는 웹 어플영역(맥락)
	
	public void init(ServletConfig config) throws ServletException {
		galleryDAO = new GalleryDAO();
		context = config.getServletContext();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//아웃 객체
		PrintWriter out = response.getWriter();
		
		//갤러리 아이디랑, 파일이름 파라미터 받기
		String gallery_id = request.getParameter("gallery_id");
		String filename = request.getParameter("filename");
		
		//이미지가 저장된 경로 가져오기
		String path = context.getRealPath("/data");
		File file = new File(path+"/"+filename);
		if(file.delete()) {
			int result = galleryDAO.delete(Integer.parseInt(gallery_id));
			if(result < 1) {
				out.print("디비 삭제 실패");
				response.sendRedirect("/gallery/detail.jsp?gallery_id="+request.getParameter("gallery_id"));
			}else {
				out.print("디비 삭제 성공");
				response.sendRedirect("/gallery/list.jsp");
			}
		}else {
			out.print("이미지 삭제 실패");
			response.sendRedirect("/gallery/detail.jsp?gallery_id="+request.getParameter("gallery_id"));
		}
	}
}







