package com.koreait.springmvc0707.model.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisConfigManager {
	private static MybatisConfigManager instance;
	SqlSessionFactory sqlSessionFactory;
	
	private MybatisConfigManager() {
		String resource = "com/koreait/springmvc0707/model/mybatis/config.xml";
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//싱글톤 패턴
	public static MybatisConfigManager getInstance() {
		if(instance == null) {
			instance = new MybatisConfigManager();
		}
		return instance;
	}
	
	//sqlSession객체 반환하가
	public SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}
	
	public void closeSqlSession(SqlSession sqlSession) {
		sqlSession.close();
	}
}














