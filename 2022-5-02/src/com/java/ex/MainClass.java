package com.java.ex;

public class MainClass {
	public static void main(String[] args) {
		String st1 = "i am namil park.";
		String st2 = "I AM A KING OF THE WORLD!";
		
		System.out.println(st1.concat(st2));
		System.out.println(st1.substring(3));
		System.out.println(st1.length());
		System.out.println(st1.toUpperCase());
		System.out.println(st2.toLowerCase());
		System.out.println(st1.charAt(3));
		System.out.println(st1.indexOf('r'));
		
		String st3 = "i am suji bae";
		
		System.out.println(st1.equals(st3));
		System.out.println(st1.trim());
		System.out.println(st1.replace('.', '!'));
		System.out.println(st1.replaceAll("i am", "you are"));
		System.out.println(st1);
	}
}
