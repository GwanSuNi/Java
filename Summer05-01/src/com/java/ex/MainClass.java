package com.java.ex;

public class MainClass {

	public static void main(String[] args) {
		int sum = 0, evenSum = 0, oddSum = 0;

		for (int i = 1; i <= 100; i++) {
			sum += i;
			if (i % 2 == 0) {
				evenSum += i;
			} else {
				oddSum += i;
			}
		}
		System.out.printf("Total: %d\n Even: %d\n  Odd: %d\n", sum, evenSum, oddSum);
	}
}
