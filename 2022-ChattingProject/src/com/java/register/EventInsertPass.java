package com.java.register;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPasswordField;

public class EventInsertPass implements ActionListener {
	JLabel j1;
	JPasswordField p1;
	int strong;

	public EventInsertPass(JPasswordField p1, JLabel j1) {
		this.p1 = p1;
		this.j1 = j1;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 실시간으로 값 확인해서 강력도 검사
		while (p1.isFocusable()) {
			switch (strong) {
			case 1:
				break;
			case 2:
				break;
			default:
				j1.setText("검사");
				break;

			}
		}
	}

}
