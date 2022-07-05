package com.java.ex;

public class MainClass {

	public static void main(String[] args) {
		Warrior w1 = new Warrior();
		w1.wInfo();
		w1.attack();
		
		Warrior w2 = new Warrior("IU", 100, 100, 100);
		w2.wInfo();
		w2.attack();
		
		Warrior w3 = new Warrior();
		w3.wInfo();
		w3.attack();
		
		w3 = w2;
		w3.setInteligent(200);
		System.out.println("New " + w2.getInteligent());
		
//		w1.setName("Hong");
//		w1.setStrength(30);
//		w1.setInteligent(30);
//		w1.wInfo();
//		w1.attack();
	}

}
