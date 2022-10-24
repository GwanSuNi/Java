package com.java.ex.car;

import com.java.ex.camera.Camera;
import com.java.ex.navigation.Navigation;
import com.java.ex.sound.Sound;

public abstract class Car {
	Sound sound;
	Navigation navigation;
	Camera camera;
	
	public Car() {
		System.out.println("차체, 바퀴, 엑셀, 브레이크 제작");
	}
	
	public abstract void makeCar();
	public abstract void getSpec();

	public Sound getSound() {
		return sound;
	}

	public void setSound(Sound sound) {
		this.sound = sound;
	}

	public Navigation getNavigation() {
		return navigation;
	}

	public void setNavigation(Navigation navigation) {
		this.navigation = navigation;
	}

	public Camera getCamera() {
		return camera;
	}

	public void setCamera(Camera camera) {
		this.camera = camera;
	}
}
