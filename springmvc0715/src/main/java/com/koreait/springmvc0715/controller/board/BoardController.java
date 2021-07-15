package com.koreait.springmvc0715.controller.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.springmvc0715.model.board.service.BoardService;
import com.koreait.springmvc0715.model.domain.Board;

import lombok.Setter;

//목록, 등록, 수정, 삭제, 상세보기를 하나의 컨트롤러에서 처리하기

@Setter
@Controller
public class BoardController {

	@Autowired //자동으로 엮을라면 엮으려는 대상들이
	private BoardService boardService;
	
	//목록 요청을 처리하는 메서드
	@RequestMapping(value="/board/list", method=RequestMethod.GET)
	public String getList(Model model) {
		//3단계
		List boardList = boardService.selectAll();
		
		//4단계
		//꼭 model and view를 이용하지 않고 model에 따로 값을 저장하고
		//url을 반환하는 방법도 사용가능.
		model.addAttribute("boardList", boardList);
		
		return "board/list";
	}
	
	//글쓰기 요청을 처리
	@RequestMapping(value="/board/regist", method=RequestMethod.POST)
	public String regist(Board board, Model model) {
		//3단계
		System.out.println("자동 매핑된 제목은 : "+board.getTitle());
		String viewName = null;
		try {
			boardService.insert(board);		
			viewName = "redirect:/board/list";
			
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("e", e);
			viewName = "error/result";
		}
		
		//개발자가 String형으로 뷰이름을 반환하면 내부적으로는 modelandView의
		//setViewName() 작성하는 것과 동일
		return viewName;
	}
	
	//상세보기 요청처리
	@RequestMapping(value="/board/detail", method=RequestMethod.GET)
	public String getDetail(int board_id, Model model) {
		Board board = boardService.select(board_id);
		
		model.addAttribute("board", board);
		
		return "board/detail";
	}
	
	//수정하기
	@RequestMapping(value="/board/update", method=RequestMethod.POST)
	public ModelAndView edit(Board board) {
		ModelAndView mav = new ModelAndView();

		try {
			boardService.update(board);
			mav.setViewName("redirect:/board/detail?board_id="+board.getBoard_id());
						
		}catch(Exception e) {
			e.printStackTrace();
			mav.setViewName("error/result");
			mav.addObject("e", e);
		}
		
		return mav;
	}
	
	//삭제하기
	@RequestMapping(value="/board/delete", method = RequestMethod.POST)
	public String delete(int board_id, Model model) {
		String viewName = null;
		try {
			boardService.delete(board_id);
			viewName = "redirect:/board/list";
			
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("e", e);
			viewName = "error/result";
		}
		return viewName;
	}
}

















