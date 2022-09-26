package com.java.ex.robot;

import com.java.ex.misile.MisileNo;
import com.java.ex.sword.UnSword;
import com.java.ex.wing.WingNo;

public class CheapRobot extends Robot{
	public CheapRobot() {
		this.makeRobot();
		wing = new WingNo();
		sword = new UnSword();
		misile = new MisileNo();
	}

	@Override
	public void makeRobot() {
		System.out.println("=== 싼 로봇 제작 ===");		
	}
	public void getSpec() {
		System.out.println("=== 싼 로봇의 스펙 ===");
		this.run();
		this.walk();
		wing.wing();
		sword.sword();
		misile.misile();
	}
}
