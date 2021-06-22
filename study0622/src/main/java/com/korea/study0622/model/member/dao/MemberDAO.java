package com.korea.study0622.model.member.dao;

import java.util.List;

import com.korea.study0622.model.domain.Member;

public interface MemberDAO {
	public Member getMemberId(String user_id); //아이디 유효성 체크
	public int regist(Member member); //회원 가입 요청
	public List selectAll(); //회원 전체 조회
	public Member select(int member_id); //멤버 한명 조회
	public int delete(int member_id); //멤버 삭제
}
