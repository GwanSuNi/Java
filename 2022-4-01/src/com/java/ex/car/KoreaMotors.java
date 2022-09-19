package com.java.ex.car;

import static java.lang.System.out;

public class KoreaMotors extends Motors {

	@Override
	public void buyK3() {
		out.println("K3 판매: 1000만원");
	}

	@Override
	public void buyK5() {
		out.println("K5 판매: 2000만원");
	}

	@Override
	public void buyK7() {
		out.println("K7 판매: 3000만원");
	}

	@Override
	public void buySportage() {
		out.println("Sportage 판매: 2500만원");
	}

	@Override
	public void buySorento() {
		out.println("Sorento 판매: 3000만원");
	}

}
