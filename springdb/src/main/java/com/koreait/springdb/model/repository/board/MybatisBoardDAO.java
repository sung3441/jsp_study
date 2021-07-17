package com.koreait.springdb.model.repository.board;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koreait.springdb.model.domain.Board;

import lombok.Setter;

@Repository //컴포넌트 스캔의 대상이 되어 자동 인스턴스 생성됨
public class MybatisBoardDAO implements BoardDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List selectAll() {
		return sqlSessionTemplate.selectList("Board.selectAll");
	}

	public void insert(Board board) throws Exception{
		sqlSessionTemplate.insert("Board.insert", board);
	}

	public Board select(int board_id){
		return sqlSessionTemplate.selectOne("Board.select", board_id);
	}

	public void update(Board board) throws Exception{
		sqlSessionTemplate.update("Board.update", board);
	}

	public void delete(int board_id) throws Exception{
		sqlSessionTemplate.delete("Board.delete", board_id);
	}
}
