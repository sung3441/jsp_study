package com.koreait.springdb.model.repository.board;

import java.util.List;

import com.koreait.springdb.model.domain.Board;

public interface BoardDAO {

	public List selectAll();
	public void insert(Board board) throws Exception;
	public Board select(int board_id);
	public void update(Board board) throws Exception;
	public void delete(int board_id) throws Exception;
}
