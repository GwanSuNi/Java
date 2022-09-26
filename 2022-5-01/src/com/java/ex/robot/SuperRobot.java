package com.java.ex.robot;

import com.java.ex.misile.MisileOk;
import com.java.ex.sword.LaserSword;
import com.java.ex.wing.WingOk;

public class SuperRobot extends Robot {
	public SuperRobot() {
		this.makeRobot();
		wing = new WingOk();
		sword = new LaserSword();
		misile = new MisileOk();	
	}
	
	@Override
	public void makeRobot() {
		System.out.println("=== 비싼 로봇 제작 ===");
	}
	public void getSpec() {
		System.out.println("=== 비싼 로봇의 스펙 ===");
		this.run();
		this.walk();
		wing.wing();
		sword.sword();
		misile.misile();
	}
}
