package com.java.ex.main;

import com.java.ex.character.*;

public class MainClass {

	// TODO: 각 직업 인스턴스 두 개씩 생성, 데미지 계산하는 메소드 소스 캡쳐, 생성자 화면, 메인 클래스, 결과화면 캡쳐, 각각 화면을 raw로 캡쳐
	public static void main(String[] args) {
		Wizard wiz1 = new Wizard("반장", 70, 100, 30, 10, 10, 100); // name, hp, mp, intel, strength, agil, money
		Wizard wiz2 = new Wizard(); // 파라미터를 주지 않은 인스턴스
		
		Archor arc1 = new Archor("부반장", 50, 70, 20, 10, 30, 50);
		Archor arc2 = new Archor("유관형", 10, 10, 10, 10, 10, 0);
		
		Warrier war1 = new Warrier("모반장", 100, 30, 10, 30, 10, 10);
		Warrier war2 = new Warrier("박윤우", 10, 10, 10, 10, 10, 0);
		
		
		// wiz1 정보 출력
		System.out.println("\"" + wiz1.getName()+ "\" 법사 정보");
		System.out.println("체력: " + wiz1.getHp());
		System.out.println("마나: " + wiz1.getMp());
		System.out.println("힘: " + wiz1.getStrength());
		System.out.println("지능: " + wiz1.getIntel());
		System.out.println("민첩: " + wiz1.getAgil());
		System.out.println("보유 머니: " + wiz1.getMoney());
		System.out.println("데미지: " + wiz1.calcDamage() + "\n");
		// wiz2 정보 출력
		System.out.println("\"" + wiz2.getName()+ "\" 법사 정보");
		System.out.println("체력: " + wiz2.getHp());
		System.out.println("마나: " + wiz2.getMp());
		System.out.println("힘: " + wiz2.getStrength());
		System.out.println("지능: " + wiz2.getIntel());
		System.out.println("민첩: " + wiz2.getAgil());
		System.out.println("보유 머니: " + wiz2.getMoney());
		System.out.println(wiz2.calcDamage() + "\n");
		
		
		// arc1 정보 출력
		System.out.println("\"" + arc1.getName()+ "\" 궁수 정보");
		System.out.println("체력: " + arc1.getHp());
		System.out.println("마나: " + arc1.getMp());
		System.out.println("힘: " + arc1.getStrength());
		System.out.println("지능: " + arc1.getIntel());
		System.out.println("민첩: " + arc1.getAgil());
		System.out.println("보유 머니: " + arc1.getMoney());
		System.out.println(arc1.calcDamage() + "\n");
		// arc2 정보 출력
		System.out.println("\"" + arc2.getName()+ "\" 궁수 정보");
		System.out.println("체력: " + arc2.getHp());
		System.out.println("마나: " + arc2.getMp());
		System.out.println("힘: " + arc2.getStrength());
		System.out.println("지능: " + arc2.getIntel());
		System.out.println("민첩: " + arc2.getAgil());
		System.out.println("보유 머니: " + arc2.getMoney());
		System.out.println(arc2.calcDamage() + "\n");
		
		
		// war1 정보 출력
		System.out.println("\"" + war1.getName()+ "\" 전사 정보");
		System.out.println("체력: " + war1.getHp());
		System.out.println("마나: " + war1.getMp());
		System.out.println("힘: " + war1.getStrength());
		System.out.println("지능: " + war1.getIntel());
		System.out.println("민첩: " + war1.getAgil());
		System.out.println("보유 머니: " + war1.getMoney());
		System.out.println(war1.calcDamage() + "\n");
		// war2 정보 출력 
		System.out.println("\"" + war2.getName()+ "\" 전사 정보");
		System.out.println("체력: " + war2.getHp());
		System.out.println("마나: " + war2.getMp());
		System.out.println("힘: " + war2.getStrength());
		System.out.println("지능: " + war2.getIntel());
		System.out.println("민첩: " + war2.getAgil());
		System.out.println("보유 머니: " + war2.getMoney());
		System.out.println(war2.calcDamage() + "\n");
		
	}

}
