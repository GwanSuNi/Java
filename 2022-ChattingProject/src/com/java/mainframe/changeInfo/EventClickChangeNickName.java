package com.java.mainframe.changeInfo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.java.db.AccountDAO;
import com.java.db.AccountDTO;

public class EventClickChangeNickName implements ActionListener {
	AccountDTO dto = null;

	public EventClickChangeNickName(AccountDTO dto) {
		this.dto = dto;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		AccountDAO dao = new AccountDAO();
		String changeNickName = JOptionPane.showInputDialog(null,"변경할 닉네임 입력");
		if (changeNickName.equals("")) {
			JOptionPane.showMessageDialog(null, "변경할 닉네임을 입력해주세요.(1~20자)", "닉네임 변경", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		try {
			dto.setNickName(changeNickName);
			if (dao.accountUpdateNickName(dto)) {
				JOptionPane.showMessageDialog(null, "닉네임 변경 성공", "닉네임 변경", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "닉네임 변경 실패", "닉네임 변경", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}

	}

}
