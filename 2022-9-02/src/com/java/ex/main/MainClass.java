package com.java.ex.main;

import com.java.ex.ThreadRunnable;

public class MainClass {

	public static void main(String[] args) {
		ThreadRunnable thRun = new ThreadRunnable();
		// 인터페이스를 Thread(Runnable, 쓰레드 이름)으로 줘야함
		Thread thread = new Thread(thRun, "쓰레드 생성");
		thread.start();
		
		System.out.println(Thread.currentThread().getName());
		System.out.println("메인 클래스");
	}

}
