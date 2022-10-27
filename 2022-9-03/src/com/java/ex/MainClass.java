package com.java.ex;

public class MainClass {

	public static void main(String[] args) {
		// 한 개의 객체에 여러 쓰레드 생성
		TestThread testThread = new TestThread();
		Thread th0 = new Thread(testThread, "첫 번째 쓰레드");
		Thread th1 = new Thread(testThread, "두 번째 쓰레드");
		th0.start();
		th1.start();
		
		System.out.println(Thread.currentThread().getName());
		System.out.println("메인 클래스");

		// 객체 하나 당 하나의 쓰레드가 존재하는 방법
//		TestThread testThread01 = new TestThread();
//		TestThread testThread02 = new TestThread();
//		
//		Thread th0 = new Thread(testThread01, "첫 번째 쓰레드");
//		Thread th1 = new Thread(testThread02, "두 번째 쓰레드");
//		th0.start();
//		th1.start();
//		
//		System.out.println(Thread.currentThread().getName());
//		System.out.println("메인 클래스");

	}

}
