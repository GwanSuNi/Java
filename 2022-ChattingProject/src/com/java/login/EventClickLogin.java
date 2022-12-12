package com.java.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.java.db.AccountDAO;
import com.java.db.AccountDTO;

import com.java.chat.*;

public class EventClickLogin implements ActionListener {
	JTextField idField;
	JPasswordField passwordField;
	JLabel passResultLabel;
	LoginPage loginPage;

	public EventClickLogin(JTextField idField, JPasswordField passwordField, JLabel passResultLabel, LoginPage loginPage) {
		this.idField = idField;
		this.passwordField = passwordField;
		this.passResultLabel = passResultLabel;
		this.loginPage = loginPage;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// DB와 아이디 비밀번호 검사 후 메인 페이지 실행

		// 아이디나 비밀번호 하나라도 입력하지 않으면
		if (idField.getText().equals("") || passwordField.getPassword() == null) {
			JOptionPane.showMessageDialog(null, "아이디 비밀번호를 모두 입력해주세요.", "로그인 불가", JOptionPane.WARNING_MESSAGE);
			idField.requestFocus();
			return;
		}

		AccountDAO dao = new AccountDAO();
		try {
			
			AccountDTO dto = dao.findAccountById(idField.getText());

			if (dto == null) {
				JOptionPane.showMessageDialog(null, "입력하신 정보는 없는 회원입니다.", "로그인 불가", JOptionPane.WARNING_MESSAGE);
				idField.requestFocus();
				return;
			}
			if (!dto.getPw().equals(new String(passwordField.getPassword()))) {
				passResultLabel.setText("아이디 혹은 비밀번호 틀림");
				passwordField.requestFocus();
				return;
			}
			passResultLabel.setText("");
//			new MainPage(dto);
			new ChatClientObject(dto).service();
			loginPage.setVisible(false);
			
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "입력하신 정보는 없는 회원입니다.", "로그인 불가", JOptionPane.WARNING_MESSAGE);
			e2.printStackTrace();
		}
	}

}
