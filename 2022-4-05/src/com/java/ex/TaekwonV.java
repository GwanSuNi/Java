package com.java.ex;

import com.java.ex.func.Laser;

public class TaekwonV implements Laser {
	
	public TaekwonV() {
		System.out.println("태권브이 생성");
	}
	
	@Override
	public void canLaser() {
		System.out.println("레이저");
	}
}
