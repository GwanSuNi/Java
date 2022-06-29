package com.java.ex;

public class MainClass {

	public static void main(String[] args) {
		int i = 10;
		int j = 3;
		int h = 5;

		System.out.println("=== 산술 연산자 ===");
		System.out.println("덧셈: " + (i + j));
		System.out.println("뺄셈: " + (i - j));
		System.out.println("곱셈: " + (i * j));
		System.out.println("나눗셈: " + (i / j));
		System.out.println("나머지: " + (i % j));

		System.out.println("=== 증감 연산자 ===");
		i++;
		System.out.println("증가: " + i);
		j--;
		System.out.println("감소: " + j);

		System.out.println("=== 비교, 관계 연산자 ===");
		System.out.println("i == j: " + (i == j));
		System.out.println("i != j: " + (i != j));
		System.out.println("i > j: " + (i > j));
		System.out.println("i < j: " + (i < j));

		System.out.println("=== 논리 연산자 ===");
		System.out.println("&& (AND): " + (i > j && i > h));
		System.out.println("&& (AND): " + (i > j && i < h));
		System.out.println("|| (OR): " + (i > j || i > h));
		System.out.println("|| (OR): " + (i > j || i < h));

		System.out.println("=== 할당 연산자 ===");
		System.out.println("h = " + h);
		h = i;
		System.out.println("h = " + h);

		System.out.println("=== 줄여쓰는 연산자 ===");
		i = i + 100;
		System.out.println("i = " + i);
		i = 11;
		System.out.println("i = " + i);
		i += 100;
		System.out.println("i = " + i);
		
		System.out.println("=== 삼항연산자 ===");
		int result = h != 5 ? 1 : 2;
		System.out.println("삼항 연산자에 대한 결과 (result): " + result);
		
	}

}
