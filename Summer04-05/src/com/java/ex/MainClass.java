package com.java.ex;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input Score > ");
		int score = scanner.nextInt();
		String grade;
		
		if(score > 100 || score < 0) {
			System.out.println("Wrong Input");
		}
		
		switch (score / 5) {
		case 20:
		case 19:
			grade = "A+";
			break;
		case 18:
			grade = "A0";
			break;
		case 17:
			grade = "B+";
			break;
		case 16:
			grade = "B0";
			break;
		case 15:
			grade = "C+";
			break;
		case 14:
			grade = "C0";
			break;
		case 13:
			grade = "D+";
			break;
		case 12:
			grade = "D0";
			break;
		default:
			grade = "F";
			break;
		}
		
		System.out.println("Grade = " + grade);

		scanner.close();
	}

}
