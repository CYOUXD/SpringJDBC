package org.zerock.mybatistest;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//스프링 컨텍스트에 등록했으니 스프링 테스트이다. -??????? 그럼 스프링 말고 다른 컨텍스트가 있나?

//스프링 설정 파일을 Test로 사용하는 방법
//pom.xml에 spring-test 라이브러리가 추가외어 있어야 함.
//pom.xml에서 Junit 버전 변경 -> 최소 4.10버전 이상이어야 함
//테스트할 때는 Run As의 JunitTest로 @Test 어노테이션 설정된 메서드 실행하여 테스트

//설정
//@RunWith로 SpringJUnit4ClassRunner.class를 동시에 구동
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration()을 통해서 설정을 불러와서 구동
@ContextConfiguration(value= {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MyBatisTest {
	
	@Autowired
	SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void testFactory() {
		System.out.println(">>>>>>>>>>>>>> sqlSessionFactory 출력 : "+ sqlSessionFactory);
	}
}
