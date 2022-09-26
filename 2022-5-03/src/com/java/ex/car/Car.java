package com.java.ex.car;

import com.java.ex.blackboxs.Blackbox;
import com.java.ex.navigations.Navigation;
import com.java.ex.sunroofs.Sunroof;

public abstract class Car {
	public Navigation navigation;
	public Blackbox blackbox;
	public Sunroof sunroof;
	
	public Car() {
		System.out.println("차체, 바퀴 4개, 핸들, 브레이크, 가속페달 제작");
	}
	
	public abstract void makeCar();

	
	public Navigation getNavigation() {
		return navigation;
	}

	public void setNavigation(Navigation navigation) {
		this.navigation = navigation;
	}

	public Blackbox getBlackbox() {
		return blackbox;
	}

	public void setBlackbox(Blackbox blackbox) {
		this.blackbox = blackbox;
	}

	public Sunroof getSunroof() {
		return sunroof;
	}

	public void setSunroof(Sunroof sunroof) {
		this.sunroof = sunroof;
	}
	
	
}
