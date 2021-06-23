package com.korea.study0622.model.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.korea.study0622.model.domain.Board;
import com.korea.study0622.model.mybatis.MybatisConfigManager;

public class MybatisBoardDAO implements BoardDAO{
	
	MybatisConfigManager configManager;
	public MybatisBoardDAO() {
		configManager = MybatisConfigManager.getInstance();
	}
	
	//값 넣기
	public int insert(Board board) {
		SqlSession sqlSession = configManager.getSession();
		int result = sqlSession.insert("Board.insert", board);
		sqlSession.commit();
		configManager.closeSession(sqlSession);
		return result;
	}

	//전체 게시글 조회
	public List selectAll() {
		SqlSession sqlSession = configManager.getSession();
		List list =  sqlSession.selectList("Board.selectAll");
		configManager.closeSession(sqlSession);
		return list;
	}

	//데이터 한 건 조회
	public Board select(int board_id) {
		SqlSession sqlSession = configManager.getSession();
		Board board = sqlSession.selectOne("Board.select", board_id);
		configManager.closeSession(sqlSession);
		return board;
	}

	//데이터 업데이트
	public int update(Board board) {
		SqlSession sqlSession = configManager.getSession();
		int result = sqlSession.update("Board.update", board);
		sqlSession.commit();
		configManager.closeSession(sqlSession);
		return result;
	}
	
	//데이터 삭제
	public int delete(int board_id) {
		SqlSession sqlSession = configManager.getSession();
		int result = sqlSession.delete("Board.delete", board_id);
		sqlSession.commit();
		configManager.closeSession(sqlSession);
		return result;
	}

}
