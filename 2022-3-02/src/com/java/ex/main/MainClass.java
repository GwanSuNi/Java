package com.java.ex.main;

import com.java.ex.car.JapanMotors;
import com.java.ex.car.KoreaMotors;
import com.java.ex.car.Motors;
import com.java.ex.car.UsaMotors;

public class MainClass {

	public static void main(String[] args) {
		
		Motors m1 = new Motors();
		
		KoreaMotors k1 = new KoreaMotors();
		JapanMotors j1 = new JapanMotors();
		UsaMotors u1 = new UsaMotors();
		
		System.out.println("---<본사 판매 금액>---");
		m1.buyk3();
		m1.buyk5();
		m1.buyk7();
		m1.buySportage();
		m1.buySorento();
		System.out.println();
		
		System.out.println("---<한국 지사 금액>---");
		k1.buyk3();
		k1.buyk5();
		k1.buyk7();
		k1.buySportage();
		k1.buySorento();
		System.out.println();
		
		System.out.println("---<일본 지사 금액>---");
		j1.buyk3();
		j1.buyk5();
		j1.buyk7();
		j1.buySportage();
		j1.buySorento();
		System.out.println();
		
		System.out.println("---<미국 지사 금액>---");
		u1.buyk3();
		u1.buyk5();
		u1.buyk7();
		u1.buySportage();
		u1.buySorento();
		System.out.println();
	}

}
