package com.java.ex;

public class MainClass {

	public static void main(String[] args) {
		int i = 1, sum = 0;
		
		while (i <= 100) {
			if (i % 3 == 0) {
				sum += i;
			}
			i++;
		}
		System.out.println("1~100까지 3의 배수의 합: " + sum);
	}

}
