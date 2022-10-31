package com.java.ex;

public class MainClass {

	public static void main(String[] args) {
		MakeButton btn = new MakeButton();
		btn.pack(); // 기본 사이즈
		// btn.setSize(200, 200);
		btn.setVisible(true);

		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		btn.setVisible(false);
		btn.dispose(); // 버튼 자원 해제

		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.exit(0); // 애플리케이션 종료

	}

}
