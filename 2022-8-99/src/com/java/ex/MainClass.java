package com.java.ex;

import com.java.ex.camera.CameraOk;
import com.java.ex.car.CheapCar;
import com.java.ex.car.StandardCar;
import com.java.ex.car.SuperCar;

public class MainClass {

	public static void main(String[] args) {
		
		SuperCar superCar = new SuperCar();
		superCar.getSpec();
		
		StandardCar standardCar = new StandardCar();
		standardCar.getSpec();
		
		CheapCar cheapCar = new CheapCar();
		cheapCar.getSpec();
		
		
		CheapCar upgradeCar = new CheapCar();
		upgradeCar.setCamera(new CameraOk());
		upgradeCar.getSpec();
	
	}

}
