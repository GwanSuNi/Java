package com.java.ex;

public class MainClass {

	public static void main(String[] args) {
		int i = 10;
		int j = 0;
		
		System.out.println(i+j);
		System.out.println(i-j);
		System.out.println(i*j);
	
		try {
			System.out.println(i/j);			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
			e.printStackTrace();
		} finally {
			System.out.println("프로그램 종료!");
		}
	}

}
