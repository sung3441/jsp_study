package com.koreait.site0622.model.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.koreait.site0622.model.domain.Member;
import com.koreait.site0622.model.mybatis.MybatisConfigManager;

public class MybatisMemeberDAO implements MemberDAO{

	MybatisConfigManager configManager;
	
	public MybatisMemeberDAO() {
		configManager = MybatisConfigManager.getInstance();
	}
	
	//아이디 조회 후 중보 검사
	public Member getMemberById(String user_id) {
		Member member = null;
		SqlSession sqlSession = configManager.getSession();
		member = sqlSession.selectOne("getMemberById", user_id);
		configManager.closeSession(sqlSession);
		return member;
	}

	public int regist(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delete(int member_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Member select(int member_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int update(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

}
