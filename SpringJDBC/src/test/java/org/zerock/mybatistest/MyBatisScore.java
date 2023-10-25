package org.zerock.mybatistest;

import java.util.List;
import java.util.Scanner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.command.ScoreVO;
import org.zerock.mapper.ScoreMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="file:src/main/webapp/WEB-INF/spring/**/root-context.xml")
public class MyBatisScore {
	//mapper 설정 (org.zerock.ScoreMapper.xml - 구현체)
	//1) 테스트 메서드는 mapper 인터페이스를 출력하는 메서드 구현
	//		root-context.xml에 mapper 스캔 관련 설정을 추가해야 함
	@Autowired
	ScoreMapper mapper;
	
	@Test
	public void test1() {
		System.out.println(">>>>>> ScoreMapper 인터페이스 구현 되는지 확인 : "+mapper);
	}
	
	//메서드 테스트
	@Test
	public void insert() {
		for(int i=1; i<=5; i++) {
			ScoreVO vo = new ScoreVO();
			vo.setName("test"+i);
			vo.setKor("100");
			vo.setEng("90");
			vo.setMath("80");
			
			boolean result = mapper.insert(vo);
			System.out.println("입력 : "+result);
		}
	}
	@Test
	public void select() {
		List<ScoreVO> list = mapper.select();
		for(ScoreVO vo : list) {
			System.out.println(vo);
		}
	}
	@Test
	public void delete() {
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 게시글 번호 : ");
		String num = scan.next();
		mapper.delete(num);
		
		System.out.println("결과 확인");
		select();
		
		scan.close();		
	}
}
