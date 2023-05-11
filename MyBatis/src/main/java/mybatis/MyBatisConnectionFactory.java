package mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConnectionFactory {
	
	//sqlSession을 만들기 위한 설정값 : Factory객체
	
	//SqlSession 객체를 생성하기 팩토리 객체
	private static SqlSessionFactory sqlSessionFactory;

	//정적 초기화 블록(싱글톤 2번째 해결방법)
	static {
		
		//마이바티스 Configuration XML 파일의 경로
		//마이바티스의 DB접속 설정을 적어두는 XML파일
		String res = "mybatis/mybatis-config.xml";
		
		try {
			//Configuration XML파일을 이용하여 문자 입력 스트림 생성
			Reader reader = Resources.getResourceAsReader(res);
			
			//싱글톤 유지
			if(sqlSessionFactory == null) {
				
				//	입력 스트림으로 읽어들인 설정 파일을 이용하여
				//SqlSessionFactory객체를 생성한다
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			
				//-> builder에 필요한 것만 넣으면 나머지는 null로 처리
				
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	//private생성자
	private MyBatisConnectionFactory() {}
	
	//싱글톤 객체 반환 메소드
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	
	//-> JDBCTemplate의 역할을 수행함
	
}
