package com.java.ex;

public class MainClass {

	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());

		
		String str = "A";
		long startNum1 = System.currentTimeMillis();

		for (int i = 0; i < 99999; i++) {
			str = str + "A";
		}
		long endNum1 = System.currentTimeMillis();
		System.out.println("String의 경과 시간: " + (endNum1 - startNum1));

		
		StringBuilder stb = new StringBuilder("A");
		long startNum2 = System.currentTimeMillis();

		for (int i = 0; i < 99999; i++) {
			stb = stb.append("A");
		}
		long endNum2 = System.currentTimeMillis();
		System.out.println("StringBuilder의 경과 시간: " + (endNum2 - startNum2));
	}

}
