package com.koreait.springdb.model.service.board;

import java.util.List;

import com.koreait.springdb.model.domain.Board;

public interface BoardService {

	public List selectAll();
	public void regist(Board board) throws Exception; //insert에 국한되지 않는다.
	public Board select(int board_id);
	public void update(Board board) throws Exception;
	public void delete(int board_id) throws Exception;
}
