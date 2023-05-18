package study.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.dao.face.BoardDao;
import study.dto.Board;
import study.service.face.BoardService;

@Service
public class BoardServiceImpl implements BoardService {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardService.class); //이미 상속을 받아서 BoardImpl 안해도 된다
	
	@Autowired BoardDao boardDao; 

	@Override
	public List<Board> getList() {
		
		logger.info("getList()");
	
		return boardDao.selectAll();
	}

}
