package com.java.ex.car;

import com.java.ex.camera.CameraNo;
import com.java.ex.navigation.NavigationOk;
import com.java.ex.sound.S5;

public class StandardCar extends Car {

	public StandardCar() {
		this.makeCar();
		camera = new CameraNo();
		navigation = new NavigationOk();
		sound = new S5();
	}
	
	@Override
	public void makeCar() {
		System.out.println("== 스탠다드카 제작 ==");
	}

	@Override
	public void getSpec() {
		System.out.println("== 스탠다드카 스펙 ==");
		sound.sound();
		navigation.navigation();
		camera.camera();
	}
}
