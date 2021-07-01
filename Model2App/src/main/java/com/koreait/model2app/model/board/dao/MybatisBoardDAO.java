package com.koreait.model2app.model.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.koreait.model2app.model.domain.Board;
import com.koreait.model2app.model.mybatis.MybatisConfigManager;

public class MybatisBoardDAO implements BoardDAO{

	MybatisConfigManager configManager;
	
	public MybatisBoardDAO() {
		configManager = MybatisConfigManager.getInstance();
	}

	public List selectAll() {
		SqlSession sqlSession = configManager.getSqlSession();
		List list = sqlSession.selectList("Board.selectAll");
		configManager.closeSqlSession(sqlSession);
		return list;
	}

	public Board select(int board_id) {
		SqlSession sqlSession = configManager.getSqlSession();
		Board board = sqlSession.selectOne("Board.select", board_id);
		configManager.closeSqlSession(sqlSession);
		return board;
	}

	@Override
	public int insert(Board board) {
		SqlSession sqlSession = configManager.getSqlSession();
		int result = sqlSession.insert("Board.insert", board);
		sqlSession.commit();
		configManager.closeSqlSession(sqlSession);
		return result;
	}

	@Override
	public int update(Board board) {
		SqlSession sqlSession = configManager.getSqlSession();
		int result = sqlSession.update("Board.update", board);
		sqlSession.commit();
		configManager.closeSqlSession(sqlSession);
		return result;
	}

	@Override
	public int delete(int board_id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
