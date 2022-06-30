package com.java.ex;

import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int lunchPrice;

		System.out.print("오늘 점심값으로 얼마나 쓸래? > ");
		lunchPrice = scanner.nextInt();

		if (lunchPrice >= 15_000) {
			System.out.println("비싸게 먹을 수 있음");
		} else if (lunchPrice >= 10_000) {
			System.out.println("적당히 먹을 수 있음");
		} else if (lunchPrice >= 5_000) {
			System.out.println("저렴하게 먹어야함");
		} else {
			System.out.println("오늘은 굶자");
		}

		scanner.close();
	}
}
