package com.java.mainframe.changeInfo;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;

import com.java.db.AccountDTO;
import com.java.register.PasswordStrongCheck;

@SuppressWarnings("serial")
public class ChangePwPage extends JFrame implements ActionListener {
	AccountDTO dto = null;
	JPasswordField oldPasswordField, newPasswordField;
	JLabel oldPwLabel, newPwLabel, pwStrongLabel;
	JProgressBar pwStrongProgressBar;
	JButton cancleButton, okButton;

	public ChangePwPage(AccountDTO dto) {
		this.dto = dto;
		Container container = getContentPane();
		BorderLayout borderLayout = new BorderLayout(10, 10);
		container.setLayout(borderLayout);

		// 센터 구성요소
		oldPwLabel = new JLabel("기존 비밀번호:", JLabel.CENTER);
		newPwLabel = new JLabel("새로운 비밀번호:", JLabel.CENTER);
		oldPasswordField = new JPasswordField();
		newPasswordField = new JPasswordField();
		pwStrongLabel = new JLabel("", JLabel.CENTER);
		
		pwStrongProgressBar = new JProgressBar();
		pwStrongProgressBar = new JProgressBar(0, 4);
		pwStrongProgressBar.setOpaque(true);
		pwStrongProgressBar.setStringPainted(true);
		pwStrongProgressBar.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		pwStrongProgressBar.setString("비밀번호 강도");
		// 비밀번호 강도 검사
		newPasswordField.addKeyListener(new PasswordStrongCheck(newPasswordField, pwStrongProgressBar));

		// 푸터 구성요소
		cancleButton = new JButton("취소");
		cancleButton.setHorizontalAlignment(JButton.CENTER);
		cancleButton.addActionListener(e -> {
			dispose();
		});

		okButton = new JButton("변경하기");
		// TODO: 그냥 바로 적용 검사는 위에서 플래그

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(3, 2));
		centerPanel.add(oldPwLabel);
		centerPanel.add(oldPasswordField);
		centerPanel.add(newPwLabel);
		centerPanel.add(newPasswordField);
		centerPanel.add(pwStrongLabel);
		centerPanel.add(pwStrongProgressBar);
		okButton.addActionListener(new EventClickChangePw(dto, pwStrongLabel, oldPasswordField, newPasswordField, pwStrongProgressBar, this));

		JPanel footerPanel = new JPanel();
		footerPanel.add(cancleButton);
		footerPanel.add(okButton);

		container.add(centerPanel, BorderLayout.CENTER);
		container.add(footerPanel, BorderLayout.SOUTH);

		setTitle("비밀번호 변경");
		setSize(300, 200);
		// 연계 위치
		setLocationRelativeTo(null);
		// 크기 조절
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		pack();
		setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		new ChangePwPage(dto);
		setVisible(true);
	}
}
