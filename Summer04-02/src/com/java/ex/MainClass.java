package com.java.ex;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		int score;
		char grade = 'F';
		Scanner scanner = new Scanner(System.in);

		System.out.print("시험 점수 입력 > ");
		score = scanner.nextInt();

		if (score >= 90) {
			grade = 'A';
		} else if (score >= 80) {
			grade = 'B';
		} else if (score >= 70) {
			grade = 'C';
		} else if (score >= 60) {
			grade = 'D';
		} else {
			grade = 'F';
		}

		System.out.println("성적은 " + grade);
		scanner.close();
	}

}
