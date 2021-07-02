package com.koreait.model2app.model.member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.koreait.model2app.exception.LicenseRegistException;
import com.koreait.model2app.model.domain.License;
import com.koreait.model2app.model.domain.Member;
import com.koreait.model2app.model.license.dao.JdbcLicenseDAO;
import com.koreait.model2app.model.license.dao.LicenseDAO;
import com.koreait.model2app.model.member.dao.JdbcMemberDAO;
import com.koreait.model2app.model.member.dao.MemberDAO;
import com.koreait.model2app.util.FileManager;
import com.koreait.model2app.util.pool.PoolManager;

//서비스 인터페이스를 구현한 구현 클래스
// 왜? 서비스에 인터페이스까지 둬야 하는지 의문이 생기겠지만 담주까지 참자
//이유 어플리케이션의 의존성을 약화시키기 위함 DI를 배워야 이해가능함
public class MemberServiceImpl implements MemberService{
	private PoolManager pool = PoolManager.getInstance();

	//부장님이 일 시킬 모델 객체들
	MemberDAO memberDAO; //회원 정보
	LicenseDAO licenseDAO; //자격증 정보
	
	public MemberServiceImpl() {
		memberDAO = new JdbcMemberDAO();
		licenseDAO = new JdbcLicenseDAO();
	}
	
	public int regist(HttpServletRequest request) {
		// 아파치 파일 업로드를 이용한 파일 저장 및 파라미터 처리
		Member member = FileManager.saveFile(request);//파일 업로드
		
		Connection con = pool.getConnection(); //DAO들에게 나눠줄 커넥션
		((JdbcMemberDAO)memberDAO).setCon(con);
		((JdbcLicenseDAO)licenseDAO).setCon(con);
		//jdbc에서의 connection은 autoCommit이 true로 설정..
		//false로 돌려놓아야함
		try {
			con.setAutoCommit(false);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		try {
			int member_id = memberDAO.insert(member);
			List<License> list = member.getList();
			for(License obj : list) {
				obj.setMember_id(member_id);
				licenseDAO.insert(obj);
			}
			try {
				con.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(LicenseRegistException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			try {
				con.rollback();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			pool.release(con);
			try {
				con.setAutoCommit(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member select(int member_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int member_id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
