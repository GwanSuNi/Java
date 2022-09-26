package com.java.ex.car;

import com.java.ex.blackboxs.BlackboxNo;
import com.java.ex.navigations.NavigationOk;
import com.java.ex.sunroofs.SunroofNormal;

public class K5 extends Car {

	public K5() {
		this.makeCar();
		navigation = new NavigationOk();
		blackbox = new BlackboxNo();
		sunroof = new SunroofNormal();
	}
	
	@Override
	public void makeCar() {
		System.out.println("=== K5 제작 ===");
	}
	
	public void getSpec() {
		System.out.println("=== K5 스펙 ===");
		navigation.navigation();
		blackbox.blackbox();
		sunroof.sunroof();
	}

}
