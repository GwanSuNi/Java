package com.java.ex;

import com.java.ex.children.FirstChild;
import com.java.ex.children.SecondChild;
import com.java.ex.children.ThirdChild;

public class MainClass {

	public static void main(String[] args) {
		FirstChild child1 = new FirstChild();
		SecondChild child2 = new SecondChild();
		ThirdChild child3 = new ThirdChild();
		
		child1.takeMoney(1500);
		child2.takeMoney(1000);
		child3.takeMoney(1000);
		
	}

}
