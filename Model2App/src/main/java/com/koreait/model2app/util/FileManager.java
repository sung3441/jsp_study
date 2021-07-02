package com.koreait.model2app.util;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.koreait.model2app.model.domain.License;
import com.koreait.model2app.model.domain.Member;

public class FileManager {

	private FileManager() {
		// TODO Auto-generated constructor stub
	}
	
	//확장자만 추출하기
	public static String getExt(String path) {
		
		return path.substring(path.lastIndexOf(".")+1, path.length());
	}
	
	//웹기반의 파일 업로드
	public static Member saveFile(HttpServletRequest request) {
		DiskFileItemFactory factory = new DiskFileItemFactory(); // 업로드 설정 객체
		ServletContext context = request.getServletContext();
		String realPath = context.getRealPath("/data"); // 실제 저장 경로 얻기
		System.out.println(realPath);
		factory.setRepository(new File(realPath));
		factory.setSizeThreshold(2 * 1024 * 1024); // 용량은 2M 제한

		ServletFileUpload upload = new ServletFileUpload(factory);
		Member member = new Member();
		try {
			List<FileItem> items = upload.parseRequest(request); // 요청 분석하여 업로드 실행
			for (FileItem item : items) {
				if (item.isFormField()) { // text필드라면..
					if (item.getFieldName().equals("name")) {
						member.setName(item.getString("utf-8"));

					} else if (item.getFieldName().equals("phone")) {
						member.setPhone(item.getString("utf-8"));

					} else if (item.getFieldName().equals("addr")) {
						member.setAddr(item.getString("utf-8"));

					} else if (item.getFieldName().equals("title")) {
						// 자격증 대입
						License license = new License();
						license.setTitle(item.getString("utf-8"));
						member.getList().add(license);//member Vo에 자격증 한 개 추가
					}
				} else { // 파일 필드라면..
					try {

						String ext = FileManager.getExt(item.getName());
						String newName = System.currentTimeMillis() + "." + ext;
						item.write(new File(realPath + "/" + newName)); // 파일 저장
						member.setPhoto(newName);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member;
	}
}
