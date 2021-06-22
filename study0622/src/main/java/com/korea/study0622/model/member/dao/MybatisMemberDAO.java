package com.korea.study0622.model.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.korea.study0622.model.domain.Member;
import com.korea.study0622.model.mybatis.MybatisConfigManager;

public class MybatisMemberDAO implements MemberDAO{

	MybatisConfigManager configManager;
	
	public MybatisMemberDAO() {
		//session객체를 얻어올 수 있는 객체 생성
		configManager = MybatisConfigManager.getInstance();
	}

	//멤버 하나 가져와서 조회
	public Member getMemberId(String user_id) {
		Member member = null;
		SqlSession sqlSession = configManager.getSession();
		member = sqlSession.selectOne("getMemberId", user_id);
		configManager.closeSession(sqlSession);
		
		return member;
	}


	public int regist(Member member) {
		
		return 0;
	}


	public List selectAll() {
		
		return null;
	}


	public Member select(int member_id) {
		
		return null;
	}

	public int delete(int member_id) {
	
		return 0;
	}

}
