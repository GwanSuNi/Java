package com.java.ex;

public class MainClass {

	public static void main(String[] args) {
		System.out.println("선거 개표 진행");
		
		VoteThread voteTH0 = new VoteThread();
		VoteThread voteTH1 = new VoteThread();
		VoteThread voteTH2 = new VoteThread();
		
		Thread th0 = new Thread(voteTH0, "제 1 선거구");
		Thread th1 = new Thread(voteTH1, "제 2 선거구");
		Thread th2 = new Thread(voteTH2, "제 3 선거구");
		
		th0.start();
		th1.start();
		th2.start();
	}

}
