package com.java.ex.iphone;

public class Iphone14 implements IphoneFunc {
	public Iphone14() {
		System.out.println("아이폰14를 생성합니다");
		System.out.println("아이폰14에는 다음과 같은 기능 포함됩니다");
		
		this.phone();
		this.generation();
		this.healthCare();
	}

	@Override
	public void phone() {
		System.out.println("전화기능 : O");
	}

	@Override
	public void generation() {
		System.out.println("통신 세대 : 5G");
	}

	@Override
	public void healthCare() {
		System.out.println("헬스 기능 : O");
	}

}
