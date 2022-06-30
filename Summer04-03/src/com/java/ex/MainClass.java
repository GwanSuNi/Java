package com.java.ex;

import java.util.Scanner;

import javax.swing.Spring;

public class MainClass {

	public static void main(String[] args) {
		int javaScore, springScore, jspScore;
		int sum = 0;
		double avg = 0.0;
		Scanner scanner = new Scanner(System.in);

		System.out.print("Java Score > ");
		javaScore = scanner.nextInt();

		System.out.print("Spring Score > ");
		springScore = scanner.nextInt();

		System.out.print("JSP Score > ");
		jspScore = scanner.nextInt();

		sum = javaScore + springScore + jspScore;
		avg = sum / 3.0;

		System.out.printf("Java Score : %d\n", javaScore);
		if (javaScore >= avg) {
			System.out.println("Above Average score");
		} else {
			System.out.println("Under Average score");
		}

		System.out.printf("Spring Score : %d\n", springScore);
		if (springScore >= avg) {
			System.out.println("Above Average score");
		} else {
			System.out.println("Under Average score");
		}

		System.out.printf("JSP Score : %d\n", jspScore);
		if (jspScore >= avg) {
			System.out.println("Above Average score");
		} else {
			System.out.println("Under Average score");
		}
		System.out.printf("Total = %d\t AVG = %2.2f\n", sum, avg);

		scanner.close();
	}

}
