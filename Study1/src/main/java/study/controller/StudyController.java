package study.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import study.dto.Board;
import study.service.face.BoardService;

@Controller
public class StudyController { //서블릿 대신 역할 
	
	private static final Logger logger = LoggerFactory.getLogger(StudyController.class);
	
	@Autowired 
	private BoardService boardService;
	
	//controller의 리턴(반환) 타입은 3개 void, String, ModelAndView
	//requestmapping 메소드 타입을 적어주는데 getmapping은 필요하다 (좀 더 간단해지고, getmapping에서 method를 지정해주면 오류가 뜬다)
	
	@GetMapping("/board/list")
	
	public void getList(Model model) {
		logger.info("/board/list [GET]");
		logger.info("/board/list [GET]");
		logger.info("/board/list [GET]");
		logger.info("/board/list [GET]");
	
		List<Board> list = boardService.getList();
		
	}
}
