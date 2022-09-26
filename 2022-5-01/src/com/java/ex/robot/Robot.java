package com.java.ex.robot;

import com.java.ex.misile.Misile;
import com.java.ex.sword.Sword;
import com.java.ex.wing.Wing;

public abstract class Robot {
	public Misile misile;
	public Sword sword;
	public Wing wing;

	public Robot() {
		System.out.println("팔, 다리, 몸통, 머리 제작");
	}

	public abstract void makeRobot();

	public void walk() {
		System.out.println("걷기: OK");
	}

	public void run() {
		System.out.println("달리기: OK");
	}

	public Misile getMisile() {
		return misile;
	}

	public void setMisile(Misile misile) {
		this.misile = misile;
	}

	public Sword getSword() {
		return sword;
	}

	public void setSword(Sword sword) {
		this.sword = sword;
	}

	public Wing getWing() {
		return wing;
	}

	public void setWing(Wing wing) {
		this.wing = wing;
	}
	

}
