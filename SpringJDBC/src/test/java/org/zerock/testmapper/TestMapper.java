package org.zerock.testmapper;

import java.util.List;

import org.zerock.command.ScoreVO;

public interface TestMapper {
	public List<ScoreVO> select();
	public String getTime();
	public boolean insert(ScoreVO vo);
}
