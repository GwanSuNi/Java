package com.java.register;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class EventClickOk implements ActionListener {
	JTextField nameField, nicknameField, idField;
	JPasswordField passwordField;

	public EventClickOk(JTextField nameField, JTextField nicknameField, JTextField idField,
			JPasswordField passwordField) {
		this.nameField = nameField;
		this.nicknameField = nicknameField;
		this.idField = idField;
		this.passwordField = passwordField;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO: DB에 가입 데이터 추가
	}

}
