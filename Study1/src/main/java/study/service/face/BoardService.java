package study.service.face;

import java.util.List;

import study.dto.Board;

public interface BoardService {
	
	/**
	 * 전체 게시판 조회
	 * 
	 * @return - 전체 게시판 DTO 객체
	 */
	public List<Board> getList();

}
