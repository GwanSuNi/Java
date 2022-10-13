package com.java.ex;

public class ThrowsExClass {
	public ThrowsExClass() {
		actionC();
	}
	
	private void actionA() throws Exception {
		System.out.println("actionA()");
		
		int[] iArr = {1,2,3,4};
		System.out.println(iArr[4]);
		// 예외가 발생해서 던짐
		
		System.out.println("actionAAAA");
		// actionAAAA 는 출력되지 않음
	}
	
	private void actionB() {
		System.out.println("actionB()");
		
		try {
			actionA();
		} catch (Exception e) {
			System.out.println("예외 여기서 처리");
			
			System.out.println(e.getMessage());
		}
		System.out.println("actionBBBB");
	}
	
	private void actionC() {
		System.out.println("actionC()");
		actionB();
		System.out.println("actionCCCC");
	}
}
