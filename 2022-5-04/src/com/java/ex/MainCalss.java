package com.java.ex;

public class MainCalss {
	public static void main(String[] args) {
		
		StringBuilder stb = new StringBuilder("I AM A KING OF THE WOLRD!");
		
		stb.append("really");
		System.out.println(stb);
		
		stb.insert(2, ", Namil Park,");
		System.out.println(stb);
		
		stb.delete(9 ,14);
		System.out.println(stb);
		
		stb.deleteCharAt(14);
		System.out.println(stb);
		
	}
}
