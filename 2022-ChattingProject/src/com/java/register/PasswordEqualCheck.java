package com.java.register;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPasswordField;

public class PasswordEqualCheck implements KeyListener {

	JPasswordField passwordField, rePasswordField;
	JLabel passStrongLabel;
	private String pw1, pw2;
	
	public PasswordEqualCheck(JPasswordField passwordField, JPasswordField rePasswordField, JLabel passStrongLabel) {
		this.passwordField = passwordField;
		this.rePasswordField = rePasswordField;
		this.passStrongLabel = passStrongLabel;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		init(passwordField, rePasswordField);
		if (equal()) {
			passStrongLabel.setText("재입력 값 동일");
			passStrongLabel.setForeground(new Color(98, 197, 84));
			RegisterPage.passEqual = true;
		} else {
			passStrongLabel.setText("재입력 값 다름");
			passStrongLabel.setForeground(new Color(236, 106, 94));
		}
	}
	
	void init(JPasswordField passwordField, JPasswordField rePasswordField) {
		pw1 = new String(passwordField.getPassword());
		pw2 = new String(rePasswordField.getPassword());
	}
	
	boolean equal() {
		return pw1.equals(pw2);
	}

}
