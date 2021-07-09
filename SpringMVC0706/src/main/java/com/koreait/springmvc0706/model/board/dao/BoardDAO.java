package com.koreait.springmvc0706.model.board.dao;

import java.util.List;

import com.koreait.springmvc0706.model.domain.Board;

public interface BoardDAO {
	public List selectAll();
	public Board select(int board_id);
	public int insert(Board board);
	public int update(Board board);
	public int delete(int board_id);
}
