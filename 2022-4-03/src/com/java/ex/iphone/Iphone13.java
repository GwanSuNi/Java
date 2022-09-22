package com.java.ex.iphone;

public class Iphone13 implements IphoneFunc {
	public Iphone13() {
		System.out.println("아이폰13을 제작합니다");
		System.out.println("아이폰13에는 다음의 기능이 포함됩니다");
		this.phone();
		this.generation();
		this.healthCare();
	}

	@Override
	public void phone() {
		System.out.println("전화 기능: O");
	}

	@Override
	public void generation() {
		System.out.println("통신 세대: 4G");
	}

	@Override
	public void healthCare() {
		System.out.println("헬스 기능: X");
	}

}
