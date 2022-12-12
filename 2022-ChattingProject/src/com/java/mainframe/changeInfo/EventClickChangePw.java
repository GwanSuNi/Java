package com.java.mainframe.changeInfo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;

import com.java.db.AccountDAO;
import com.java.db.AccountDTO;

public class EventClickChangePw implements ActionListener {
	AccountDTO dto = null;
	JLabel pwStrongLabel;
	JProgressBar pwStrongProgressBar;
	JPasswordField oldPasswordField, newPasswordField;
	ChangePwPage page;
	private String oldPw = null;
	private String changedPw = null;

	public EventClickChangePw(AccountDTO dto, JLabel pwStrongLabel, JPasswordField oldPasswordField,
			JPasswordField newPasswordField, JProgressBar pwStrongProgressBar, ChangePwPage page) {
		this.dto = dto;
		this.pwStrongLabel = pwStrongLabel;
		this.pwStrongProgressBar = pwStrongProgressBar;
		this.oldPasswordField = oldPasswordField;
		this.newPasswordField = newPasswordField;
		this.page = page;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		AccountDAO dao = new AccountDAO();
		oldPw = new String(oldPasswordField.getPassword());
		changedPw = new String(newPasswordField.getPassword());
		System.out.println(oldPw);
		System.out.println(changedPw);
		if (oldPw.equals("") || changedPw.equals("")) {
			JOptionPane.showMessageDialog(null, "비밀번호를 입력해주세요.", "비밀번호 변경", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		try {
			AccountDTO findDto = dao.findAccountById(dto.getId());
			if (dao.accountUpdatePW(findDto, oldPw, changedPw)) {
				System.out.println("비밀번호 수정 성공");
				JOptionPane.showMessageDialog(null, "비밀번호 변경 완료", "비밀번호 변경", JOptionPane.INFORMATION_MESSAGE);
				page.dispose();
				return;
			} else {
				System.out.println("비밀번호 수정 실패");
				JOptionPane.showMessageDialog(null, "비밀번호 변경 실패", "비밀번호 변경", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

}
