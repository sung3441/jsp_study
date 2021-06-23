package com.koreait.site0622.model.news.dao;

import java.util.List;

import com.koreait.site0622.model.domain.News;

public interface NewsDAO {
	public int insert(News news); //글 등록
	public List selectAll(); //모든 레코드 가져오기
	public News select(int news_id); //한 건 가져오기
	public int update(News news); //수정
	public int delete(int news_id); //삭제
	
}
