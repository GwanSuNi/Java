package com.java.ex.car;

public abstract class CarModel {
	public String color;
	public String tyre;
	public int displacement;
	public String gear;

	public abstract void getSpec();
	public abstract int calcTax();
}
