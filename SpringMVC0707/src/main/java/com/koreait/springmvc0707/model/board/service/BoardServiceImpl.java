package com.koreait.springmvc0707.model.board.service;

import java.util.List;

import com.koreait.springmvc0707.model.board.repository.BoardDAO;
import com.koreait.springmvc0707.model.domain.Board;

import lombok.Setter;

public class BoardServiceImpl implements BoardService{
	
	@Setter
	private BoardDAO boardDAO; //스프링의 컨테이너로부터 주입
	
	@Override
	public List selectAll() {
		List<Board> list = boardDAO.selectAll(); 
		return list;
	}

	@Override
	public void insert(Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Board select(int board_id) {
		Board board = boardDAO.select(board_id);
		return board;
	}

	@Override
	public void update(Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int board_id) {
	}
}
