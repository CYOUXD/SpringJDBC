package org.zerock.mybatistest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.command.ScoreVO;
import org.zerock.testmapper.TestMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MyBatisInsert {
	@Autowired
	TestMapper mapper;
	
	@Test
	public void insert() {
		try {
			//VO 널기
			ScoreVO vo = new ScoreVO();
			vo.setName("홍길동");
			vo.setKor("100");
			vo.setEng("90");
			vo.setMath("80");
			
			boolean result = mapper.insert(vo);
			System.out.println("성공? :"+result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
