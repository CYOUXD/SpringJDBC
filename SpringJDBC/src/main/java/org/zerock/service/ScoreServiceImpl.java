package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.command.ScoreVO;
import org.zerock.mapper.ScoreMapper;

@Service("scoreService")
public class ScoreServiceImpl implements ScoreService {
	
	@Autowired
	ScoreMapper mapper;
	
	@Override
	public void scoreRegist(ScoreVO vo) {
		boolean result = mapper.insert(vo);
		System.out.println("insert 결과 : "+result);
	}

	@Override
	public List<ScoreVO> scoreResult() {
		List<ScoreVO> list = mapper.select();
		return list;
	}

	@Override
	public void scoreDelete(String num) {
		mapper.delete(num);
	}

}
