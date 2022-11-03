package com.java.ex.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class EventSpidermanButton implements ActionListener {
	JLabel j1;
	
	public EventSpidermanButton(JLabel j1) {
		this.j1 = j1;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		j1.setText("스파이더맨~~~~");
	}

}
