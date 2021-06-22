package com.korea.study0622.model.mybatis;

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
		String resource = "com/korea/study0622/model/mybatis/config.xml";
		try {
			
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//싱글톤으로 인스턴스 객체 얻어오기
	public static MybatisConfigManager getInstance() {
		if(instance == null) {
			instance = new MybatisConfigManager();
		}
		return instance;
	}
	
	//session 팩토리에서 session하나 가져오는 메서드
	public SqlSession getSession() {
		return sqlSessionFactory.openSession();
	}
	
	//할당 받은 session객체 자원 해제하는 메서드
	public void closeSession(SqlSession sqlSession) {
		sqlSession.close();
	}
}
