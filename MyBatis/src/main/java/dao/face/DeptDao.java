package dao.face;

import java.util.List;

import dto.Dept;

public interface DeptDao {
	
	/**
	 * 부서 번호를 이용하여 특정 부서 정보를 조회한다
	 * @param deptno - 조회할 부서 번호
	 * @return - 조회된 부서의 모든 컬럼 정보
	 */
	public Dept selectByDeptno(int deptno);

	/**
	 * 전체 부서 정보 조회
	 * @return - 조회된 정체 부서 정보 목록
	 */
	public List<Dept> selectAll();
	
	/**
	 * 부서 이름을 이용한 조회
	 * @param dname - 조회할 부서명
	 * @return 부서 정보 DTO
	 */
	public Dept selectByDname(String dname);
	
	/**
	 * 부서 이름을 이용한 조회
	 * @param dname - 조회할 부서이름을 가진 DTO 객체
	 * @return - 조회된 부서 정보 객체
	 */
	public Dept selectByDeptDname(Dept dname);

	/**
	 * 새로운 부서 정보 삽입
	 * @param input - 삽입할 부서 정보
	 * @return INSERT 수행 결과(0: 영향받은 행 없음, int: 영향받은 행 수)
	 */
	public int insertDept(Dept input);
	//-> 반환타입이 바뀌어도 상관없음
	//-> mybatis쪽은 변경할 내용 없음
}
