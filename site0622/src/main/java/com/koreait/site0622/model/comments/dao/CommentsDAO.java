package com.koreait.site0622.model.comments.dao;


import java.util.List;

import com.koreait.site0622.model.domain.Comments;

public interface CommentsDAO {

	public int insert(Comments comments);
	public List selectAll();
	public Comments select(int comments_id);
	public int update(Comments comments);//수정
	public int delete(int comments_id);//삭제
	public List selectByNewsId(int news_id);
}
