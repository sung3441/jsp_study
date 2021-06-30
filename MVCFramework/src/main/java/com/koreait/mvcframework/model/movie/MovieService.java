package com.koreait.mvcframework.model.movie;

public class MovieService {
	
	public String getAdvice(String movie) {
		String msg = null;
		if(movie.equals("미션임파서블")) {
			msg = "미션임파서블 ㄸ 꿀잼";
		}else if(movie.equals("행복")){
			msg = "임수정 너무 예뻐욧";
		}else if(movie.equals("남자가사랑할때")) {
			msg = "황정민의 남자가 사랑할 때";
		}else if(movie.equals("어바웃타임")) {
			msg = "감동 영화 어바웃 타임쓰";
		}
		return msg;
	}
}
