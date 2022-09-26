package com.java.ex.main;

import com.java.ex.car.K3;
import com.java.ex.car.K5;
import com.java.ex.car.K7;
import com.java.ex.navigations.NavigationOk;

public class MainClass {
	public static void main(String[] args) {
		K3 defaultk3 = new K3();
		defaultk3.getSpec();

		K5 k5 = new K5();
		k5.getSpec();
		
		K7 k7 = new K7();
		k7.getSpec();
		
		
		K3 newK3 = new K3();
		newK3.setNavigation(new NavigationOk());
		newK3.getSpec();
	}
	
}
