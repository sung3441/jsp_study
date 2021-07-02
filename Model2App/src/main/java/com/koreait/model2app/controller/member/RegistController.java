package com.koreait.model2app.controller.member;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.koreait.model2app.controller.Controller;
import com.koreait.model2app.model.domain.License;
import com.koreait.model2app.model.domain.Member;
import com.koreait.model2app.model.license.dao.JdbcLicenseDAO;
import com.koreait.model2app.model.license.dao.LicenseDAO;
import com.koreait.model2app.model.member.dao.JdbcMemberDAO;
import com.koreait.model2app.model.member.dao.MemberDAO;
import com.koreait.model2app.model.member.service.MemberService;
import com.koreait.model2app.model.member.service.MemberServiceImpl;
import com.koreait.model2app.util.FileManager;

public class RegistController implements Controller {

	// 3단계 : 알맞는 로직객체에 일 시킨다, 4단계 : 결과가 있을 때는 저장
	MemberService memberService;
	
	
	public RegistController() {
		memberService = new MemberServiceImpl();
	}
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		Member member = new Member();
		member.setName(request.getParameter("name"));
		
		memberService.regist(request);
	}

	@Override
	public String getViewName() {
		// TODO Auto-generated method stub
		return "/result/member/regist";
	}

	@Override
	public boolean isForward() {
		// TODO Auto-generated method stub
		return false;
	}		

}
