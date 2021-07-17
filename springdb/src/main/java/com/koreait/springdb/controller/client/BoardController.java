package com.koreait.springdb.controller.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.springdb.model.domain.Board;
import com.koreait.springdb.model.service.board.BoardService;

import lombok.Setter;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/board/list", method=RequestMethod.GET)
	public String getList(Model model) {
		List<Board> boardList = boardService.selectAll();
		
		model.addAttribute("boardList", boardList);
		
		return "user/board/list";
	}
	
	@RequestMapping(value = "/board/detail", method = RequestMethod.GET)
	public String getDetail(int board_id, Model model) {
		Board board = boardService.select(board_id);
		
		model.addAttribute("board", board);
		return "user/board/detail";
	}
	
	@RequestMapping(value = "/board/regist", method = RequestMethod.POST)
	public String regist(Board board, Model model) throws Exception{
		String viewName = null;
		
		try {
			boardService.regist(board);
			viewName = "redirect:/client/board/list.jsp";
		}catch (Exception e){
			e.printStackTrace();
			model.addAttribute("e", e);
			viewName = "error/result";
		}
		return viewName;
	}
	
	@RequestMapping(value = "/board/update", method = RequestMethod.POST)
	public String update(Board board, Model model) {
		String viewName = null;
		
		try {
			boardService.update(board);
			viewName = "redirect:/client/board/detail.jsp?board_id="+board.getBoard_id();
		}catch (Exception e){
			e.printStackTrace();
			model.addAttribute("e", e);
			viewName = "error/result";
		}
		
		return viewName;
	}
	
	@RequestMapping(value = "/board/delete", method = RequestMethod.POST)
	public String delete(int board_id, Model model) {
		String viewName = null;
		
		try {
			boardService.delete(board_id);
			viewName = "redirect:/client/board/list.jsp";
		}catch (Exception e){
			e.printStackTrace();
			model.addAttribute("e", e);
			viewName = "error/result";
		}
		
		return viewName;
	}
	
}
