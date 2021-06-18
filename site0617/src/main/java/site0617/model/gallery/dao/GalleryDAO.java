package site0617.model.gallery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import site0617.model.domain.Gallery;
import site0617.model.pool.PoolManager;

//이 클래스는 오직 gallery에 테이블에 대한 crud 만을 담당
public class GalleryDAO {

	PoolManager pool = PoolManager.getInstance();
	
	public int insert(Gallery gallery) {
		Connection con = pool.getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "insert into gallery(gallery_id, title, writer, content, filename) values(seq_gallery.nextval, ?, ?, ?, ?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, gallery.getTitle());
			pstmt.setString(2, gallery.getWriter());
			pstmt.setString(3, gallery.getContent());
			pstmt.setString(4, gallery.getFilename());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			pool.release(con, pstmt);
		}
		return result;
	}
	
	//목록
	public List selectAll() {
		Connection con = pool.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from gallery";
		ArrayList<Gallery> list = new ArrayList<Gallery>();
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Gallery gallery = new Gallery();
				gallery.setGallery_id(rs.getInt("gallery_id"));
				gallery.setTitle(rs.getString("title"));
				gallery.setWriter(rs.getString("writer"));
				gallery.setContent(rs.getString("content"));
				gallery.setFilename(rs.getString("filename"));
				gallery.setRegdate(rs.getString("regdate"));
				gallery.setHit(rs.getInt("hit"));
				
				list.add(gallery);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			pool.release(con, pstmt, rs);
		}
		return list;
	}
	
	public Gallery select(int gallery_id) {
		Connection con = pool.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Gallery gallery = null;
		
		String sql = "select * from gallery where gallery_id="+gallery_id;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				gallery = new Gallery();
				gallery.setGallery_id(rs.getInt("gallery_id"));
				gallery.setTitle(rs.getString("title"));
				gallery.setWriter(rs.getString("writer"));
				gallery.setContent(rs.getString("content"));
				gallery.setFilename(rs.getString("filename"));
				gallery.setRegdate(rs.getString("regdate"));
				gallery.setHit(rs.getInt("hit"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			pool.release(con, pstmt, rs);
		}
		return gallery;
	}
	
	public void update() {
		
	}
	
	public int delete(int gallery_id) {
		Connection con = pool.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "delete from gallery where gallery_id = "+gallery_id;
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			pool.release(con, pstmt);
		}
		return result;
	}
}

























