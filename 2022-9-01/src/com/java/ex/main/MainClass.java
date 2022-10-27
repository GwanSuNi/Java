package com.java.ex.main;

import com.java.ex.ThreadClassExtends;

public class MainClass {
	public static void main(String[] args) {
		ThreadClassExtends thCE = new ThreadClassExtends();
		// setName() 안하고 ThreadClassExtends("쓰레드 생성") 도 가능
		thCE.setName("쓰레드 생성");
		thCE.start();
		
		// 쓰레드가 종료됐기 때문에 안찍힘
		System.out.println(Thread.currentThread().getName());
		// 각자 실행되기 때문에 실행을 먼저 끝낸 mian의 이 것이 먼저 출력됨
		System.out.println("메인 클래스");
	}
}
