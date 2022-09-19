package com.java.ex;

import com.java.ex.car.BasicModel;
import com.java.ex.car.CarModel;
import com.java.ex.car.GrandModel;
import com.java.ex.car.Spec;

public class MainClass {

	public static void main(String[] args) {
		CarModel basic1 = new BasicModel(Spec.COLOR_BLACK, Spec.TYRE_THIN, Spec.DISPLACEMENT_1500, Spec.GEAR_STICK);
		
		System.out.println("===<기본 모델>===");
		basic1.getSpec();
		System.out.println("세금: " + basic1.calcTax() + " 만원");
		System.out.println();
		
		CarModel grand1 = new GrandModel(Spec.COLOR_PEARL, Spec.TYRE_FAT, Spec.DISPLACEMENT_2500, Spec.GEAR_AUTO);
		System.out.println("===<큰 모델>===");
		grand1.getSpec();
		System.out.println("세금: " + grand1.calcTax() + " 만원");
		System.out.println();
	}

}
