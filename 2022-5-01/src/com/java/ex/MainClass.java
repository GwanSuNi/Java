package com.java.ex;

import com.java.ex.robot.CheapRobot;
import com.java.ex.robot.StandardRobot;
import com.java.ex.robot.SuperRobot;
import com.java.ex.sword.IronSword;

public class MainClass {

	public static void main(String[] args) {
		SuperRobot sr = new SuperRobot();
		StandardRobot standard = new StandardRobot();
		CheapRobot cheap = new CheapRobot();

		sr.setSword(new IronSword());
		sr.getSpec();

		standard.getSpec();
		cheap.getSpec();
	}

}
