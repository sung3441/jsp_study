package com.koreait.site0625.model.reboard.dao;

import java.util.List;

import com.koreait.site0625.model.domain.ReBoard;

public interface ReBoardDAO {
	public int insert(ReBoard reBoard);
	public List selectAll();
	public ReBoard select(int reboard_id);
	public int update(ReBoard reBoard);
	public int delete(int reboard_id);
	public int updateStep(ReBoard reBoard);	//답변 등록을 위한 자리 확보
	//답변 등록
	public int reply(ReBoard reBoard);
}
