package com.java.register;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class EventClickOverLap implements ActionListener {
	JTextField id1;
	JLabel l1;

	public EventClickOverLap(JTextField id1, JLabel l1) {
			this.id1 = id1;
			this.l1 = l1;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO: 데이터베이스에서 중복 검사
		if (!id1.getText().equals("")) {
			l1.setText("OK");
			// 중복 검사 하는 과정
		} else
			l1.setText("아이디를 입력해주세요");
	}

}
