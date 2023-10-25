package org.zerock.service;

import java.util.List;

import org.zerock.command.ScoreVO;

public interface ScoreService {
	//점수 등록
	public void scoreRegist(ScoreVO vo);
	//점수 결과
	public List<ScoreVO> scoreResult();
	//점수 삭제
	public void scoreDelete(String num);
}
