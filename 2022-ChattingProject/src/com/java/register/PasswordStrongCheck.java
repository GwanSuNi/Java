package com.java.register;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;

import javax.swing.JPasswordField;
import javax.swing.JProgressBar;

public class PasswordStrongCheck implements KeyListener {

	JPasswordField passwordField;
	JProgressBar passStrongProgressBar;
	private String pw;
//	String regId = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%_])[a-zA-Z0-9!@#$%_]{3,20}$";
	String regId = "^[a-zA-Z0-9!@#$%_]{3,20}$";
	String engUpperRegex = "[A-Z]";
	String engLowerRegex = "[a-z]";
	String numRegex = "[0-9]";
	String specRegex = "[!@#$%_]";

	public PasswordStrongCheck(JPasswordField passwordField, JProgressBar passStrongProgressBar) {
		this.passwordField = passwordField;
		this.passStrongProgressBar = passStrongProgressBar;
		pw = new String(passwordField.getPassword());
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		init(passwordField, passStrongProgressBar);
		if (Pattern.matches(regId, pw)) {
			System.out.println(e.getKeyChar());
			int count = 0;
			count += Pattern.compile(engUpperRegex).matcher(pw).find() ? 1 : 0;
			count += Pattern.compile(engLowerRegex).matcher(pw).find() ? 1 : 0;
			count += Pattern.compile(numRegex).matcher(pw).find() ? 1 : 0;
			count += Pattern.compile(specRegex).matcher(pw).find() ? 1 : 0;

			switch (count) {
			case 4:
				passStrongProgressBar.setValue(count);
				passStrongProgressBar.setString("안전");
				passStrongProgressBar.setBackground(new Color(98, 197, 84));
				break;
			case 3:
				passStrongProgressBar.setValue(count);
				passStrongProgressBar.setString("보통");
				passStrongProgressBar.setBackground(Color.cyan);
				break;
			case 2:
				passStrongProgressBar.setValue(count);
				passStrongProgressBar.setString("미흡");
				passStrongProgressBar.setBackground(new Color(245, 191, 79));
				break;
			case 1:
				passStrongProgressBar.setValue(count);
				passStrongProgressBar.setString("최악");
				passStrongProgressBar.setBackground(new Color(236, 106, 94));
				break;
			}

		} else {
			passStrongProgressBar.setValue(0);
			passStrongProgressBar.setString("조건 미부합");
			passStrongProgressBar.setBackground(new Color(236, 106, 94));
			System.out.println(e.getKeyChar());
		}

	}

	// 갱신
	void init(JPasswordField passwordField, JProgressBar passStrongProgressBar) {
		this.passwordField = passwordField;
		this.passStrongProgressBar = passStrongProgressBar;
		pw = new String(passwordField.getPassword());
	}

}
