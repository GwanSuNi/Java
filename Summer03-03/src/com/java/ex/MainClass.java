package com.java.ex;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		int inputNum;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("정수를 입력> ");
		inputNum = scanner.nextInt();
		
		System.out.println("입력한 수는 " + inputNum);
		System.out.println((inputNum % 3 == 0) ? "3의 배수" : "3의 배수 아님");
		scanner.close();
	}

}