package com.java.ex;

public class ThreadClassExtends extends Thread {
	@Override
	public void run() { // Thread가 돌아갈 부분 구현
		System.out.println(Thread.currentThread().getName()); // 메인 클래스에서 실행되기 때문에 main 출력
		System.out.println("쓰레드 클래스 상속 클래스");
		
		for (int i =0; i<10; i++) {
			System.out.println(i);
			try { // sleep() 는 Try 문에 사용해야 함 - 프로세스가 죽어서 다시 돌아올 수 없을 수 있기 때문
				Thread.sleep(500);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
}