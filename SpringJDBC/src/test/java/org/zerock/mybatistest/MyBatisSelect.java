package org.zerock.mybatistest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.command.ScoreVO;
import org.zerock.testmapper.TestMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value= {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MyBatisSelect {
	
	//MyBatis는 DAO를 대체한다.
	//마이바티스 매퍼(mapper 스캔 또는 직접 지정, 매퍼인터페이스, 매퍼 xml 설정이 존재해야 함)
	@Autowired
	private TestMapper mapper;
	//????????? 왜 이름이 mapper지? testMapper여야 하지 않나? 얘는 어디서 연결된거지? 어디서 mapper라는 이름이 된거지?
	//답 : 타입이 TestMapper로 같으니까 연결 됨. 타입이 중복되는 게 있으면 이름으로 찾는데 여기엔 하나뿐이라 이름을 아무거나 지어도 되는 것
	//답 : TestMapper.xml의 mapper 태그로 연결 된 것. SQL문 구현도 xml에서 한다.
	
	@Test
	public void select() {
		String time = mapper.getTime(); //추상 메서드. 구현체가 있는 xml 파일을 찾아 연결해 준다.
		System.out.println(time); //select sysdate from dual의 결과
		
		List<ScoreVO> list = mapper.select();
		for(ScoreVO vo : list) {
			System.out.println(vo);
		}
	}
}
