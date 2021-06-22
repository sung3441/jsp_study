package com.koreait.site0622.model.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//Mybatis의 설정파일 xml을 읽어들이는 클래슨
public class MybatisConfigManager {

	private SqlSessionFactory sqlSessionFactory;
	private static MybatisConfigManager instance;
	
	private MybatisConfigManager() {
		//mybatis의 설정파일의 위치
		//xml은 .java 즉 클래스가 아니다. 따라서 패키지에 들어있는 xml은 일반 리소스로 취급하자
		//따라서 접근 경로는 일반 디렉토리 취급하면 안된다.
		String resource = "com/koreait/site0622/model/mybatis/config.xml";
		
		try {
			//xml을 읽기 위한 스트림 설정
			InputStream inputStream = Resources.getResourceAsStream(resource);
			//sqlSession 객체로 개발자는 쿼리문을 수행할 수 있고, 이 sqlSession 객체를 모아놓은
			//객체를 sqlSessionFactory라고 한다.
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//누구든지 이 객체의 인스턴스를 가져가려면 new를 할 수 없고 오직 아래의 메서드를 통해 가져가게 제한.
	public static MybatisConfigManager getInstance() {
		if(instance == null) {
			instance = new MybatisConfigManager();
		}
		return instance;
	}
	
	//쿼리 수행용 SqlSession을 반환받아 갈 수 있는 메서드 정의
	public SqlSession getSession() {
		//session factory의 openSession메서드롤 통해 세션을 얻어 반환하기.
		return sqlSessionFactory.openSession();
	}
	
	//다 사용된 SqlSession 반납
	public void closeSession(SqlSession sqlSession) {
		sqlSession.close();
	}
}
