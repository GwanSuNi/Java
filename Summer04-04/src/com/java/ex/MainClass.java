package com.java.ex;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		int input;
		Scanner scanner = new Scanner(System.in);

		System.out.print("숫자 입력 > ");
		input = scanner.nextInt();

		switch (input % 3) {
		case 1:
			System.out.println("아찌");
			break;

		case 2:
			System.out.println("니");
			break;

		default:
			System.out.println("쌈");
		}

		scanner.close();
	}

}
