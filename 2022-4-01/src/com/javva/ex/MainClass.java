package com.javva.ex;

import com.java.ex.car.ChinaMotors;
import com.java.ex.car.KoreaMotors;
import com.java.ex.car.Motors;

public class MainClass {

	public static void main(String[] args) {
		// 부모 클래스는 자식 클래스의 생성자를 사용 가능
		Motors m1 = new KoreaMotors();
		System.out.println("===<한국 지사>===");
		m1.buyK3();
		m1.buyK5();
		m1.buyK7();
		m1.buySportage();
		m1.buySorento();
		System.out.println();
		
		Motors m2 = new ChinaMotors();
		System.out.println("===<중국 지사>===");
		m2.buyK3();
		m2.buyK5();
		m2.buyK7();
		m2.buySportage();
		m2.buySorento();
		System.out.println();
		
	}

}
