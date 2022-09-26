package com.java.ex.car;

import com.java.ex.blackboxs.BlackboxNo;
import com.java.ex.navigations.NavigationNo;
import com.java.ex.sunroofs.SunroofNo;

public class K3 extends Car {
	public K3() {
		this.makeCar();
		navigation = new NavigationNo();
		blackbox = new BlackboxNo();
		sunroof = new SunroofNo();
	}

	@Override
	public void makeCar() {
		System.out.println("=== K3 제작 ===");
	}
	
	public void getSpec() {
		System.out.println("=== K3 스펙 ===");
		navigation.navigation();
		blackbox.blackbox();
		sunroof.sunroof();
	}
}
