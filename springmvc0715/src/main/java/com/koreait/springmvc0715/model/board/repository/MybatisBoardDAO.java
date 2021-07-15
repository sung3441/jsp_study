package com.koreait.springmvc0715.model.board.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.koreait.springmvc0715.exception.DMLException;
import com.koreait.springmvc0715.model.domain.Board;
import lombok.Setter;

@Setter
@Repository
public class MybatisBoardDAO implements BoardDAO{

	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	@Override
	public List selectAll() {
		List boardList =sessionTemplate.selectList("Board.selectAll");
		return boardList;
	}

	@Override
	//여기서 에러를 처리해버리면, 미궁에 빠짐 뷰 단까지 에러의 원인을 전달해야 한다.
	//그래야 사용자들이 에러가 발생 했을을 인식하고, 개발자는 적절한 에러 처리 가능
	public void insert(Board board) throws DMLException{
		sessionTemplate.insert("Board.insert", board);
	}

	@Override
	public Board select(int board_id) {
		return sessionTemplate.selectOne("Board.select", board_id);
	}

	@Override
	public void update(Board board) throws DMLException{
		sessionTemplate.update("Board.update", board);
	}

	@Override
	public void delete(int board_id) throws DMLException{
		sessionTemplate.delete("Board.delete", board_id);
	}
}
