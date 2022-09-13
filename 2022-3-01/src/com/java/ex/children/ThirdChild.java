package com.java.ex.children;

import com.java.ex.papa.PapaPouch;

public class ThirdChild {
	public int takeMoney(int money) {
		System.out.println("셋 째 용돈 줘야지~");
		
		if (PapaPouch.MONEY <= 0) {
			System.out.println("이제 아빠가 돈이 없다! 셋째 탈락!\n");
			return 0;
		}
		if (PapaPouch.MONEY <= money) {
			System.out.println("남은 돈 [" + PapaPouch.MONEY + "원] 다 줬다!\n");
			PapaPouch.MONEY = 0;
			return 0;
		}
		
		PapaPouch.MONEY -= money;
		System.out.println("[" + money + "원] 줬다!\n");
		return 0;
	}
}
