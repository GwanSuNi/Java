package com.java.ex.car;

import com.java.ex.camera.CameraNo;
import com.java.ex.navigation.NavigationNo;
import com.java.ex.sound.SoundNo;

public class CheapCar extends Car {
	public CheapCar() {
		this.makeCar();
		camera = new CameraNo();
		navigation = new NavigationNo();
		sound = new SoundNo();
	}
	
	@Override
	public void makeCar() {
		System.out.println("== 깡통카 제작 ==");
	}

	@Override
	public void getSpec() {
		System.out.println("== 깡통카 스펙 ==");
		sound.sound();
		navigation.navigation();
		camera.camera();
	}
	
}
