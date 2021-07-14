package com.koreait.springmvc0714.model.board.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.koreait.springmvc0714.exception.DMLException;
import com.koreait.springmvc0714.model.domain.Board;
import com.koreait.springmvc0714.model.mybatis.MybatisConfigManager;

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
	//여기서 에러를 처리해버리면, 미궁에 빠짐 뷰 단까지 에러의 원인을 전달해야 한다.
	//그래야 사용자들이 에러가 발생 했을을 인식하고, 개발자는 적절한 에러 처리 가능
	public void insert(Board board) throws DMLException{
		SqlSession sqlSession = configManager.getSqlSession();
		int result = sqlSession.insert("Board.insert", board); //에러가 날 수도 있다.
		sqlSession.commit();
		configManager.closeSqlSession(sqlSession);
		
		if(result == 0) {
			throw new DMLException("등록 실패");
		}
	}

	@Override
	public Board select(int board_id) {
		SqlSession sqlSession = configManager.getSqlSession();
		Board board = sqlSession.selectOne("Board.select", board_id);
		configManager.closeSqlSession(sqlSession);
		return board;
	}

	@Override
	public void update(Board board) throws DMLException{
		SqlSession sqlSession = configManager.getSqlSession();
		int result = sqlSession.update("Board.update", board);
		sqlSession.commit();
		configManager.closeSqlSession(sqlSession);
		
		if(result == 0) {
			throw new DMLException("수정 실패");
		}
	}

	@Override
	public void delete(int board_id) throws DMLException{
		SqlSession sqlSession = configManager.getSqlSession();
		int result = sqlSession.delete("Board.delete", board_id);
		sqlSession.commit(); 
		configManager.closeSqlSession(sqlSession);
		if(result == 0) {
			throw new DMLException("삭제 실패");
		}
	}
	
}
