package com.java.mainframe.changeInfo;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.java.db.AccountDTO;

@SuppressWarnings("serial")
public class MyInfoPage extends JFrame {
	JLabel idLabel, emailLabel, nicknameLabel, expLabel;
	JButton changeNicknameButton, changePWButton;
	JButton okButton;

	public MyInfoPage(AccountDTO dto) {
		Container container = getContentPane();
		BorderLayout borderLayout = new BorderLayout(0, 10);
		container.setLayout(borderLayout);

		// 센터 구성요소
		idLabel = new JLabel(dto.getId(), JLabel.CENTER);
		emailLabel = new JLabel(dto.getEmail(), JLabel.CENTER);
		nicknameLabel = new JLabel(dto.getNickName(), JLabel.CENTER);
		expLabel = new JLabel("", JLabel.CENTER);
		expLabel.setText(new String("" + dto.getExp()));
		
		// 푸터 구성요소
		changeNicknameButton = new JButton("닉네임 변경");
		changeNicknameButton.setHorizontalAlignment(JButton.CENTER);
		changeNicknameButton.addActionListener(new EventClickChangeNickName(dto));
		
		changePWButton = new JButton("비밀번호 변경");
		changePWButton.setHorizontalAlignment(JButton.CENTER);
		changePWButton.addActionListener(new ChangePwPage(dto));
		
		okButton = new JButton("확인");
		okButton.addActionListener(e -> {
			dispose();
		});

		
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(5, 2));
		centerPanel.add(new JLabel("아이디", JLabel.CENTER));
		centerPanel.add(idLabel);
		centerPanel.add(new JLabel("이메일", JLabel.CENTER));
		centerPanel.add(emailLabel);
		centerPanel.add(new JLabel("닉네임", JLabel.CENTER));
		centerPanel.add(nicknameLabel);
		centerPanel.add(new JLabel("경험치", JLabel.CENTER));
		centerPanel.add(expLabel);
		centerPanel.add(changeNicknameButton);
		centerPanel.add(changePWButton);
		
		JPanel footerPanel = new JPanel();
		footerPanel.add(okButton);
		

		container.add(centerPanel, BorderLayout.CENTER);
		container.add(footerPanel, BorderLayout.SOUTH);

		setTitle("내 정보");
		setSize(300, 200);
		// 연계 위치
		setLocationRelativeTo(null);
		// 크기 조절
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
//		pack();
		setVisible(true);
	}

}
