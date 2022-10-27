package com.java.ex;

public class ThreadRunnable implements Runnable {
	@Override
	public void run() { // Thread가 돌아갈 부분 구현
		System.out.println(Thread.currentThread().getName());
		System.out.println("Runnable Thread Test");
		
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
