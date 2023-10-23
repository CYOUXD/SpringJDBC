package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.command.BoardVO;
import org.zerock.dao.BoardDAO;

@Service("boardService") //= 컴포넌트의 일종. 빈 그래프에 등록이 됨
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDAO boardDAO;
	
	@Override
	public void register(String name, String title, String content) {
		//boardRegister.jsp 로 부터 전달 받은 값 확인
		System.out.println("----------- service 계층 ------------");
		System.out.println(name);
		System.out.println(title);
		System.out.println(content);
		
		boardDAO.boardInsert(name, title, content);
		
	}

	@Override
	public List<BoardVO> getList() {
		List<BoardVO> List = boardDAO.boartSelect();
		return List;
	}

	@Override
	public void delete(String num) {
		//System.out.println("삭제 index : "+num);
		boardDAO.boardDelete(num);

	}

}
