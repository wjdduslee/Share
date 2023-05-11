package dao;

import java.util.List;

import dto.Emp;

public interface EmpDao {
	
	/**
	 * 전체 Emp 정보를 조회한다
	 * @return - 조회된 전체 사원 목록
	 */
	public List<Emp> selectAll();
	
	/**
	 * 신규 사원 정보를 삽입한다
	 * @param insertEmp - 새로 삽입할 사원 정보
	 */
//	public void insert(Emp insertEmp);
	public int insert(Emp insertEmp);
	
	/**
	 * 사원번호를 이용하여 특정 사원 정보를 조회한다
	 * @param empno - 조회할 사원번호를 가진 DTO객체
	 * @return - 조회된 사원 정보
	 */
	public Emp selectByEmpno(Emp empno);

	/**
	 * 사원번호를 이용하여 특정 사원 정보를 삭제한다
	 * @param empno - 삭제할 사원번호를 가진 DTO객체
	 */
	public void deleteByEmpno(Emp empno);
	
}
