package com.koreait.model2app.model.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.koreait.model2app.model.domain.Member;
import com.koreait.model2app.util.pool.PoolManager;

import lombok.Data;

@Data
public class JdbcMemberDAO implements MemberDAO{
	private Connection con;
	
	public int insert(Member member) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into member(member_id, name, phone, addr, photo)";
		sql += " values(seq_member.nextval, ?, ?, ?, ?)";
		int result = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getName());
			System.out.println("폰 정보는 : "+member.getPhone());
			pstmt.setString(2, member.getPhone());
			pstmt.setString(3, member.getAddr());
			pstmt.setString(4, member.getPhoto());
			
			result = pstmt.executeUpdate();
			
			if(result != 0) {
				
				//현재 세션이 닫히기 전에 얼른 이 Insert에 의해 증가된 seq 값 얻어오기
				sql = "select seq_member.currval as member_id from dual";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery(); //select문 수행
				
				if(rs.next()) {		//레코드가 있다면			
					result = rs.getInt("member_id");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member select(int member_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int member_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
