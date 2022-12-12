package com.java.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.java.db.AccountDAO;
import com.java.db.AccountDTO;

public class EventClickForgotPass implements ActionListener {
	JTextField idField, emailField;
	String regEmail = "\\w+@\\w++\\.\\w+(\\.\\w+)?";

	public EventClickForgotPass(JTextField idField, JTextField emailField) {
		this.idField = idField;
		this.emailField = emailField;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 입력 누락 시
		if (idField.getText().equals("") || emailField.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "모두 입력해주세요.", "검색 불가", JOptionPane.WARNING_MESSAGE);
			idField.requestFocus();
			return;
		}
		// 이메일 패턴 아닐 시
		if (!Pattern.matches(regEmail, emailField.getText())) {
			JOptionPane.showMessageDialog(null, "유효한 이메일 형식이 아닙니다.", "이메일 형식 오류", JOptionPane.WARNING_MESSAGE);
			emailField.requestFocus();
			return;
		}
		
		AccountDAO dao = new AccountDAO();
		try {
			AccountDTO dto = dao.findAccountById(idField.getText());
			// 아이디 값이 없으면
			if (dto == null) {
				JOptionPane.showMessageDialog(null, "해당 아이디로 가입된 회원은 없습니다.", "회원 없음", JOptionPane.WARNING_MESSAGE);
				return;
			}
			// 이메일까지 동일하면
			if (dto.getEmail().equals(emailField.getText())) {
				JOptionPane.showMessageDialog(null, "아이디: " + dto.getId() + "\n비밀번호: " + new String(dto.getPw()),
						"회원 정보", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, dto.getId() + " 님은 해당 이메일로 가입하지 않았습니다.", "정보 틀림", JOptionPane.WARNING_MESSAGE);
				return;
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

}
