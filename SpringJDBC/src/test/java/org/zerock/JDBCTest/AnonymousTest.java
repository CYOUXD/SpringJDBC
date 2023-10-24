package org.zerock.JDBCTest;

import org.junit.Test;

//Car 인터페이스 생성
interface Car {
	public void run();
}

public class AnonymousTest {
	@Test //테스트할 메서드에 추가. 단위 테스트
	public void good() {
		Car car = new Car() { //익명 클래스 구현
			
			@Override
			public void run() {
				System.out.println("삐그덕 삐그덕");
			}
		};
		
		//보통의 경우 구현하는 별도의 클래스를 생성하여 사용하지만 
		//재사용할 일이 없다면 익명 클래스로 선언하여 1회성으로 사용한다.
		car.run(); //오버라이드 된 메서드 실행
		
		//----------------------------------------------------
		
		DB.query(new Car() {
			
			@Override
			public void run() {
				System.out.println("오버라이딩 된 메서드 실행");
			}
		});
	}
}

//DB 클래스
class DB{
	static void query(Car car) {
		car.run();
		System.out.println("여기서는 전달 받은 Car 객체로 SQL 문을 처리합니다.");
	}
}
