package com.koreait.site0622.model.domain;

import lombok.Data;


	public class Member { //member 테이블을 VO형태로 클래스화
		//member의 컬럼들
		private int member_id;
		private String user_id;
		private String password;
		private String name;
		private String regdate;
		
		//게터 세터
		public int getMember_id() {
			return member_id;
		}
		public void setMember_id(int member_id) {
			this.member_id = member_id;
		}
		public String getUser_id() {
			return user_id;
		}
		public void setUser_id(String user_id) {
			this.user_id = user_id;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getRegdate() {
			return regdate;
		}
		public void setRegdate(String regdate) {
			this.regdate = regdate;
		}		
	}
