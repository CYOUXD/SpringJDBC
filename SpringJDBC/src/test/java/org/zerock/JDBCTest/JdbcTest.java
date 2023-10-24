package org.zerock.JDBCTest;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class JdbcTest {

	//오라클 DB 연결 테스트
	String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
	String user = "spring";
	String password = "spring";
	
	//@Test 어노테이션을 통해서 메서드 실행 테스트
	@Test
	public void JdbcTest() {
		try {
			//JDBC 드라이버 호출
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println(">>>>>>>>> Connection 객체 생성 : "+conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
