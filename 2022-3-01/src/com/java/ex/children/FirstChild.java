package com.java.ex.children;

import com.java.ex.papa.PapaPouch;

public class FirstChild {
	public int takeMoney(int money) {
		System.out.println("첫 째 용돈 줘야지~");
		// TODO: 목요일 아침까지 남은 돈보다 요구하는 돈이 더 클 때의 로직 추가
		
		if (PapaPouch.MONEY <= 0) {
			System.out.println("이제 아빠가 돈이 없다! 첫째 탈락!\n");
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
