package com.java.ex.singletone;

public class ClassB {
	public ClassB() {
		SingletonClass sgtClass = SingletonClass.getSingletonClass();
		System.out.println("ClassB");
		System.out.println("i = " + sgtClass.getI());
	}

}
