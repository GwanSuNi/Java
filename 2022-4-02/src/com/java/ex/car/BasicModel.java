package com.java.ex.car;

public class BasicModel extends CarModel {
	private String color;
	private String tyre;
	private int displacement;
	private String gear;
	
	protected int tax;
	
	public BasicModel(String color, String tyre, int displacement, String gear) {
		this.color = color;
		this.tyre = tyre;
		this.displacement = displacement;
		this.gear = gear;
	}
	
	@Override
	public void getSpec() {
		System.out.println("색상: " + color);
		System.out.println("타이어: " + tyre);
		System.out.println("배기량: " + displacement);
		System.out.println("기어: " + gear);
	}
	
	@Override
	public int calcTax() {
		if (displacement >= 2000) {
			return 150;			
		} else if (displacement < 2000) {
			return 100;
		}
		return 0;
	}

}
