package com.java.ex;

public class TestThread implements Runnable {

	int testNum = 0;

	// synchronized 를 사용하면 하나의 쓰레드가 완료된 후 다음 쓰레드가 실행됨
	@Override
	public synchronized void run() {
		for (int i = 0; i < 10; i++) {
			if (Thread.currentThread().getName().equals("첫 번째 쓰레드")) {
				System.out.println("================");
				testNum++;
			}
			System.out.println("쓰레드 이름: " + Thread.currentThread().getName() + ", 테스트 숫자: " + testNum);
			
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
