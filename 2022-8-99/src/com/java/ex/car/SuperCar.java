package com.java.ex.car;

import com.java.ex.camera.CameraOk;
import com.java.ex.navigation.NavigationOk;
import com.java.ex.sound.S7;

public class SuperCar extends Car {

	public SuperCar() {
		this.makeCar();
		camera = new CameraOk();
		navigation = new NavigationOk();
		sound = new S7();
	}
	
	@Override
	public void makeCar() {
		System.out.println("== 슈퍼카 제작 ==");
	}

	@Override
	public void getSpec() {
		System.out.println("== 슈퍼카 스펙 ==");
		sound.sound();
		navigation.navigation();
		camera.camera();
	}
	
}
