package com.java.ex.car;

import com.java.ex.blackboxs.BlackboxOk;
import com.java.ex.navigations.NavigationOk;
import com.java.ex.sunroofs.SunroofPanorama;

public class K7 extends Car {

	public K7() {
		this.makeCar();
		navigation = new NavigationOk();
		blackbox = new BlackboxOk();
		sunroof = new SunroofPanorama();
	}
	
	@Override
	public void makeCar() {
		System.out.println("=== K7 제작 ===");
	}
	
	public void getSpec() {
		System.out.println("=== K7 스펙 ===");
		navigation.navigation();
		blackbox.blackbox();
		sunroof.sunroof();
	}

}
