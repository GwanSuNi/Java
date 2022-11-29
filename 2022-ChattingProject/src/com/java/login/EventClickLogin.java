package com.java.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.java.mainframe.MainPage;

public class EventClickLogin implements ActionListener {
	JTextField idField;
	JPasswordField passwordField;
	
	public EventClickLogin(JTextField idField, JPasswordField passwordField) {
		this.idField = idField;
		this.passwordField = passwordField;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// DB와 아이디 비밀번호 검사 후 메인 페이지 실행
		
		new MainPage();
	}

}
