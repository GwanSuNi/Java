package com.java.ex;

import com.java.ex.singletone.ClassA;
import com.java.ex.singletone.ClassB;

public class MainClass {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ClassA ac = new ClassA();
		ClassB bc = new ClassB();
	}

}
