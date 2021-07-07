package com.koreait.springmvc0707.model.board.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.koreait.springmvc0707.model.domain.Board;
import com.koreait.springmvc0707.model.mybatis.MybatisConfigManager;

import lombok.Setter;

@Setter
public class MybatisBoardDAO implements BoardDAO{

	private MybatisConfigManager configManager;
	
	@Override
	public List selectAll() {
		SqlSession session = configManager.getSqlSession();
		List boardList = session.selectList("Board.selectAll"); //쿼리 수행 후 반환 받기
		configManager.closeSqlSession(session);
		return boardList;
	}

	@Override
	public void insert(Board board) {

	}

	@Override
	public Board select(int board_id) {
		SqlSession sqlSession = configManager.getSqlSession();
		Board board = sqlSession.selectOne("Board.select", board_id);
		configManager.closeSqlSession(sqlSession);
		return board;
	}

	@Override
	public void update(Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int board_id) {
		// TODO Auto-generated method stub
		
	}
	
}
