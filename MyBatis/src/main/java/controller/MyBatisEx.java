package controller;

import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dao.face.DeptDao;
import dto.Dept;
import mybatis.MyBatisConnectionFactory;

public class MyBatisEx {

	public static void main(String[] args) {
		
		//SqlSession객체를 생성할 팩토리 객체
		SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
		
		//마이바티스 실행 객체
		SqlSession sqlSession = null;
		
		//DB 접속(sqlSessionFactory -> 이 객체를 
		// 통해 실행) 및 SQL수행 객체 생성
		sqlSession = sqlSessionFactory.openSession(); //AutoCommit OFF
//		sqlSession = sqlSessionFactory.openSession(true); //AutoCommit ON
//		sqlSession = sqlSessionFactory.openSession(false); //AutoCommit OFF

		//수동 Commit/Rollback
//		sqlSession.commit();
//		sqlSession.rollback();
		
		//--------------------------------------------------------
		
		//마이바티스 매퍼와 자바프로그램의 DAO인터페이스가 매핑(연결)된다
		DeptDao deptDao = sqlSession.getMapper(DeptDao.class);
		//왜 .class로 써야 하는지 getMapper()메소드의 설정방법인가?
		
		System.out.println("마이바티스 로드 완료!");
		
		
		//마이바티스를 이용한 SQL수행
		Dept dept = deptDao.selectByDeptno(40);
//		System.out.println("20번 부서 : " + dept);
//		System.out.println("10번 부서 : " + dept);
//		System.out.println("30번 부서 : " + dept);
		System.out.println("40번 부서 : " + dept);
		
		//--------------------------------------------------------
		
		System.out.print(" >>조회할 부서번호 입력 : ");
		Dept dept2 = deptDao.selectByDeptno( new Scanner(System.in).nextInt());
		
		System.out.println(" >> " + dept2);
		//-> 조회된 결과가 없으면 null값 반환

		//--------------------------------------------------------
		
		//전체 부서정보 조회
		List<Dept> list = deptDao.selectAll();
		
		System.out.println("\n---부서 전체 목록---");
		for(Dept d : list) {
			System.out.println(d);
		}
		
		//--------------------------------------------------------
		
//		String dname = "ACCOUNTING";
//		String dname = "SALES";
		String dname = "RESEARCH";
		Dept res1 = deptDao.selectByDname(dname);
		
		System.out.println("\n---부서명을 이용한 조회---");
		System.out.println(res1);
	
		//--------------------------------------------------------

		Dept data = new Dept();
//		data.setDname("RESEARCH");
		data.setDname("SALES");
		
		Dept res2 = deptDao.selectByDeptDname(data);
		
		System.out.println("\n---부서명(DTO)을 이용한 조회---");
		System.out.println(res2);
		
		//--------------------------------------------------------
		
		System.out.println("\n--- 새로운 부서 정보 삽입---");
		Dept input = new Dept();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("부서 번호는? ");
		input.setDeptno(sc.nextInt());
		
		System.out.print("부서 이름은? ");
		sc.nextLine();
		input.setDname(sc.nextLine());
		
		System.out.print("부서 위치는? ");
		input.setLoc(sc.nextLine());
		
//		deptDao.insertDept(input);
		//-> AutoCommit되어있음
		
		//중복확인
		//위에서 setDeptno()한 값이 == input.getDeptno()이 되고
		//입력한 부서 번호가 존재하지 않으면
		//정보 삽입하고 commit()까지 하고 아니면 (부서번호가 존재하면) '이미 존재..'
		//문구 출력
		Dept isDulicate = deptDao.selectByDeptno(input.getDeptno());
		
		if(isDulicate == null) {
			//중복 deptno없음

			int rows = deptDao.insertDept(input);
			System.out.println("영향받은 행 수 : " + rows);
			
			sqlSession.commit();
			
		} else {
			//중복 deptno있음
			System.out.println(" ** 이미 존재하는 부서 번호입니다 ** ");
		}
		
		System.out.println("삽입 결과 : " + deptDao.selectByDeptno(input.getDeptno()));
		
	}

	
	//주석 추가!!!
}
