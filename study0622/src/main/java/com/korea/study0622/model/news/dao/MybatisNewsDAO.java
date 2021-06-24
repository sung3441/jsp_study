package com.korea.study0622.model.news.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.korea.study0622.model.domain.News;
import com.korea.study0622.model.mybatis.MybatisConfigManager;

public class MybatisNewsDAO implements NewsDAO{

	MybatisConfigManager configManager;
	public MybatisNewsDAO() {
		configManager = MybatisConfigManager.getInstance();
	}
	
	//뉴스 등록
	public int insert(News news) {
		SqlSession sqlSession = configManager.getSession();
		int result = sqlSession.insert("News.insert", news);
		sqlSession.commit();
		configManager.closeSession(sqlSession);
		return result;
	}

	//뉴스 전체 가져오기
	public List selectAll() {
		SqlSession sqlSession = configManager.getSession();
		List list = sqlSession.selectList("News.selectAll");
		configManager.closeSession(sqlSession);
		return list;
	}

	//뉴스 한건 가져오기
	public News select(int news_id) {
		SqlSession sqlSession = configManager.getSession();
		News news = sqlSession.selectOne("News.select", news_id);
		configManager.closeSession(sqlSession);
		return news;
	}

	public int update(News news) {
		SqlSession sqlSession = configManager.getSession();
		int result = sqlSession.update("News.update", news);
		sqlSession.commit();
		configManager.closeSession(sqlSession);
		return result;
	}

	public int delete(int news_id) {
		SqlSession sqlSession = configManager.getSession();
		int result = sqlSession.delete("News.delete", news_id);
		sqlSession.commit();
		configManager.closeSession(sqlSession);
		return result;
	}

}
