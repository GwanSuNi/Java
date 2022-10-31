package com.java.ex;

import java.awt.Button;
import java.awt.Frame;

@SuppressWarnings("serial")
public class MakeButton extends Frame {
	public MakeButton() {
		Button btn = new Button("버튼");
		add(btn); // Frame의 메서드
	}
}
