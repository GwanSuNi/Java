package com.java.ex.singletone;

public class ClassA {
	
	public ClassA() {
		SingletonClass sgtClass = SingletonClass.getSingletonClass();
		
		System.out.println("ClassA");
		System.out.println("i = " + sgtClass.getI());
		sgtClass.setI(100);
		System.out.println("i = " + sgtClass.getI());
	}
	
}
