package com.koreait.site0625.model.reboard.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.koreait.site0625.model.domain.ReBoard;
import com.koreait.site0625.model.mybatis.MybatisConfigManager;

public class MybatisReboardDAO implements ReBoardDAO{

	//쿼리문 수행객체를 얻기위한 sqlSessionFactory객체를 관리하는 매니저 선언
	MybatisConfigManager configManager;
	
	public MybatisReboardDAO() {
		configManager = MybatisConfigManager.getInstance();
	}
	
	//등록 후, pk를 반환하는 메서드
	//반환 값이 0이면 입력 실패, 아니라면 입력 성공
	public int insert(ReBoard reBoard) {
		SqlSession sqlSession = configManager.getSession();
		
		int result = sqlSession.insert("ReBoard.insert", reBoard);
		reBoard.setTeam(reBoard.getReboard_id());
		sqlSession.update("ReBoard.updateTeam", reBoard);//팀 수정
		
		sqlSession.commit();
		
		configManager.closeSession(sqlSession);
		return result;
	}

	public List selectAll() {
		SqlSession sqlSession = configManager.getSession();
		List list = sqlSession.selectList("ReBoard.selectAll");
		configManager.closeSession(sqlSession);
		return list;
	}

	public ReBoard select(int reboard_id) {
		SqlSession sqlSession = configManager.getSession();
		ReBoard reBoard = sqlSession.selectOne("ReBoard.select", reboard_id);
		configManager.closeSession(sqlSession);
		return reBoard;
	}

	@Override
	public int update(ReBoard reBoard) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int reboard_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateStep(ReBoard reBoard) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int reply(ReBoard reBoard) {
		// TODO Auto-generated method stub
		return 0;
	}

}
