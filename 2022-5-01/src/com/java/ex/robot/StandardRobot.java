package com.java.ex.robot;

import com.java.ex.misile.MisileOk;
import com.java.ex.sword.IronSword;
import com.java.ex.wing.WingNo;

public class StandardRobot extends Robot{
	public StandardRobot() {
		this.makeRobot();
		wing = new WingNo();
		sword = new IronSword();
		misile = new MisileOk();
	}
	@Override
	public void makeRobot() {
		System.out.println("=== 기본 로봇 제작 ===");
	}
	public void getSpec() {
		System.out.println("=== 기본 로봇의 스펙 ===");
		this.run();
		this.walk();
		wing.wing();
		sword.sword();
		misile.misile();
	}
}
