package com.koreait.springdb.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardController {

	@RequestMapping(value="/test", method=RequestMethod.GET)
	public void test() {
		System.out.println("클라이언트의 test 호출");
	}
}
