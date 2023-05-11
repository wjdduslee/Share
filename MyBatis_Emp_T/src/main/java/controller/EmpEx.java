package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dao.EmpDao;
import dto.Emp;
import mybatis.MyBatisConnectionFactory;

public class EmpEx {

	public static void main(String[] args) {
		
		SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();
		
		SqlSession sqlSession = factory.openSession();
		
		//-----------------------------------------------------------
		
		//selectList / selectOne -> 반환 객체에 따라 반환 타입이 맞춰서 바뀜
//		List<Emp> list = sqlSession.selectList("empMapper.selectAll");
//		
//		for(Emp e : list) {
//			System.out.println(e);
//		}
		
		//-----------------------------------------------------------

//		int empno = 7934;
		
		//sql 코드 + 매개변수 1개만
//		Emp emp = sqlSession.selectOne("empMapper.selectByEmpno",empno);
		//-> 값만 전달할 때 mapper에 아무 문자나 써도 인식한다
		//매개변수 여러 개 전달하고 싶을 때 -> Emp()
//		Emp emp2 = sqlSession.selectOne("empMapper.selectByEmpno",new Emp());
		//Map으로 묶어서 전달
//		Emp emp3 = sqlSession.selectOne("empMapper.selectByEmpno",new HashMap());
		
//		System.out.println("emp : " + emp);
		
		//-----------------------------------------------------------
		
		//반환타입이 모두 int형
//		int rows1 = sqlSession.insert(null);
//		int rows2 = sqlSession.update(null);
//		int rows3 = sqlSession.delete(null);
		
		//-----------------------------------------------------------

		//-> 위에 처럼 직접 sql구문을 사용하는 경우 close()를 해주어야 한다
//		sqlSession.close();
		
		//-----------------------------------------------------------
		
		//EmpDao 추상메소드를 분석한다
		EmpDao empDao = sqlSession.getMapper(EmpDao.class);
		//sqlSession.getMapper(EmpDao.class) : empDaoImpl을 생성하는 것과 같다
		
		List<Emp> list1 = empDao.selectAll();
		
		System.out.println("------전체 출력------");
		for(Emp e : list1) {
			System.out.println(e);
		}
		
		//-----------------------------------------------------------
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n--- 신규 정보 삽입---");
		
		Emp insertEmp = new Emp();
		
		System.out.print(">> 사원 번호? ");
		insertEmp.setEmpno(sc.nextInt());
		
		System.out.print(">> 사원 이름 ? ");
		sc.nextLine();
		//-> nextInt()뒤에 버퍼 지우기
		insertEmp.setEname(sc.nextLine());
		
		System.out.print(">> 직무는 ? ");
		insertEmp.setJob(sc.nextLine());
		
		System.out.print(">> 매니저 번호는 ? ");
		insertEmp.setMgr(sc.nextInt());
		
		System.out.print(">> 입사 날짜는(yyyy-MM-dd)? ");
		sc.nextLine();
		String data = sc.nextLine();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date hiredate = null;
		try {
			hiredate = sdf.parse(data);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		insertEmp.setHiredate(hiredate);
		
		System.out.print(">> 급여 ? ");
		insertEmp.setSal(sc.nextDouble());

		System.out.print(">> 상여금 ? ");
		insertEmp.setComm(sc.nextDouble());
		
		System.out.print(">> 부서번호 ? ");
		insertEmp.setDeptno(sc.nextInt());
		
		int res = empDao.insert(insertEmp);
		//-> autoCommit상태가 아니기 때문에 DB에 반영되지 않음
		
		if ( res > 0 ) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		//-----------------------------------------------------------

		System.out.println("\n--- 삽입 결과 출력 ----");
		System.out.println(empDao.selectByEmpno(insertEmp));
		
		//-----------------------------------------------------------

		System.out.println("\n--- 삭제 ----");
		empDao.deleteByEmpno(insertEmp);
		
		//delete도 트랜잭션 관리
		sqlSession.commit();

		//-----------------------------------------------------------
		
		System.out.println("\n--- 전체 출력 ---");
		for (Emp e : empDao.selectAll()) System.out.println(e);
		
	}
	
}
