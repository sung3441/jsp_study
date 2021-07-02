package com.koreait.model2app.model.member.dao;

import java.sql.Connection;
import java.util.List;

import com.koreait.model2app.model.domain.Member;

public interface MemberDAO {
	public int insert(Member member);
	public List selectAll();
	public Member select(int member_id);
	public int update(Member member);
	public int delete(int member_id);
}
