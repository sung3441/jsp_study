package com.koreait.springmvc0715.model.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.springmvc0715.exception.DMLException;
import com.koreait.springmvc0715.model.board.repository.BoardDAO;
import com.koreait.springmvc0715.model.domain.Board;

import lombok.Setter;

@Setter
@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAO boardDAO; //스프링의 컨테이너로부터 주입
	
	@Override
	public List selectAll() {
		List<Board> list = boardDAO.selectAll(); 
		return list;
	}

	@Override
	public void insert(Board board) throws DMLException{
		boardDAO.insert(board);
	}

	@Override
	public Board select(int board_id) {
		Board board = boardDAO.select(board_id);
		return board;
	}

	@Override
	public void update(Board board) throws DMLException{
		boardDAO.update(board);
	}

	@Override
	public void delete(int board_id) throws DMLException{
		boardDAO.delete(board_id);
	}
}
