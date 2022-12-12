package com.java.register;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.java.db.AccountDAO;
import com.java.db.AccountDTO;

public class EventClickOk implements ActionListener {
	JTextField nicknameField, idField, emailField;
	JPasswordField passwordField, rePasswordField;
	RegisterPage registerPage;
	String regEmail = "\\w+@\\w++\\.\\w+(\\.\\w+)?";

	public EventClickOk(JTextField nicknameField, JTextField emailField, JTextField idField,
			JPasswordField passwordField, JPasswordField rePasswordField, RegisterPage registerPage) {
		this.nicknameField = nicknameField;
		this.emailField = emailField;
		this.idField = idField;
		this.passwordField = passwordField;
		this.rePasswordField = rePasswordField;
		this.registerPage = registerPage;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String pw1 = new String(passwordField.getPassword());
		String pw2 = new String(rePasswordField.getPassword());

		if (!Pattern.matches(regEmail, emailField.getText())) {
			JOptionPane.showMessageDialog(null, "유효한 이메일 형식이 아닙니다.", "이메일 형식 오류", JOptionPane.WARNING_MESSAGE);
			emailField.requestFocus();
			return;
		}
		if (!RegisterPage.idOverlap) {
			JOptionPane.showMessageDialog(null, "중복 검사를 먼저 만족해주세요.", "중복 검사 누락", JOptionPane.WARNING_MESSAGE);
			idField.requestFocus();
			return;
		}
		if (!pw1.equals(pw2)) {
			JOptionPane.showMessageDialog(null, "비밀번호 값이 다릅니다.", "비밀번호 오류", JOptionPane.WARNING_MESSAGE);
			passwordField.requestFocus();
			return;
		}

		if (!nicknameField.getText().equals("") && !emailField.getText().equals("") && !idField.getText().equals("")
				&& passwordField.getPassword() != null && rePasswordField.getPassword() != null
				&& RegisterPage.idOverlap && RegisterPage.passEqual) {
//			System.out.println("닉네임: " + nicknameField.getText());
//			System.out.println("이메일: " + emailField.getText());
//			System.out.println("아이디: " + idField.getText());
//			System.out.println(passwordField.getPassword());
//			System.out.println(rePasswordField.getPassword());

			AccountDAO dao = new AccountDAO();
			try {
				// TODO: 비밀번호 암호화
				AccountDTO dto = new AccountDTO(idField.getText(), pw1, emailField.getText(), nicknameField.getText(),
						0);
				if (dao.accountInsert(dto)) {
					System.out.println("회원 가입 성공");
					JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.", "회원가입 결과", JOptionPane.INFORMATION_MESSAGE);
					registerPage.dispose();
					return;
				} else {
					System.out.println("회원 가입 실패");
					JOptionPane.showMessageDialog(null, "회원가입에 문제가 발생했습니다. \n입력하신 정보를 다시 확인해주세요.", "회원가입 불가",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		} else {
			JOptionPane.showMessageDialog(null, "내용을 모두 입력해주세요", "회원가입 불가", JOptionPane.INFORMATION_MESSAGE);
			System.out.println("내용 모두 입력 안됨");
		}
	}

}
