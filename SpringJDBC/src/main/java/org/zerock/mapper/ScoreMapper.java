package org.zerock.mapper;

import java.util.List;
import java.util.Map;

import org.zerock.command.ScoreVO;

public interface ScoreMapper {
	
	//점수 등록
	public boolean insert(ScoreVO vo);
	public boolean insert2(Map<String, String> map);
	
	//점수 리스트 출력
	public List<ScoreVO> select();
	
	//점수 삭제
	public void delete(String num);
}
