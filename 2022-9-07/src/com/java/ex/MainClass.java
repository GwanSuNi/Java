package com.java.ex;

public class MainClass {

	public static void main(String[] args) {
		MakeComponent makeComponent = new MakeComponent();
		// 각각의 사이즈에 맞게 알아서
		makeComponent.pack();
		makeComponent.setVisible(true);
	}

}
