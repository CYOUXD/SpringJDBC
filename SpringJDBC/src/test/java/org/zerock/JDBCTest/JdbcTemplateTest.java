package org.zerock.JDBCTest;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//spring-test 라이브러리가 추가되어야 동작함
@RunWith(SpringJUnit4ClassRunner.class) //스프링 환경에서 테스트하기 위한 클래스 지정
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml") //루트 컨텍스트 부르기
public class JdbcTemplateTest {
	@Autowired
	DataSource ds;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Test
	public void testTemplate() {
		try {
			Connection conn = ds.getConnection();
			System.out.println(">>>>>>>>>>>>>>>> Connection 객체 : "+conn);
			
			System.out.println(">>>>>>>>>>>>>>>> 템플릿 객체 생성 : "+jdbcTemplate);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
