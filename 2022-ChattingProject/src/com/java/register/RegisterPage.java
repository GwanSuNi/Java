package com.java.register;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class RegisterPage extends JFrame {
	JTextField emailField, nickNameField, idField;
	JPasswordField passwordField, rePasswordField;
	JButton overlapCheckButton, cancleButton, registerButton;
	JLabel passStrongLabel, idOverlapLabel;
	JProgressBar passStrongProgressBar;
	protected static boolean idOverlap = false;
	protected static boolean passEqual = false;

	public RegisterPage() {
		idOverlap = false;
		Container container = getContentPane();
		BorderLayout borderLayout = new BorderLayout();
		container.setLayout(borderLayout);
		container.setMinimumSize(new Dimension(800, 600));

		// label 생성 그리드 박스 내 글씨 정렬을 위해 변수 선언
		JLabel emailLabel, nicknameLabel, idLabel, passwordLabel, rePasswordLabel;
		nicknameLabel = new JLabel("닉네임 입력 (1~20자):");
		nicknameLabel.setHorizontalAlignment(JLabel.CENTER);
		emailLabel = new JLabel("이메일 입력:");
		emailLabel.setHorizontalAlignment(JLabel.CENTER);
		idLabel = new JLabel("아이디 입력:");
		idLabel.setHorizontalAlignment(JLabel.CENTER);
		passwordLabel = new JLabel("비밀번호 입력:");
		passwordLabel.setHorizontalAlignment(JLabel.CENTER);
		rePasswordLabel = new JLabel("비밀번호 재입력:");
		rePasswordLabel.setHorizontalAlignment(JLabel.CENTER);

		emailField = new JTextField();
		emailField.setHorizontalAlignment(JTextField.CENTER);

		nickNameField = new JTextField();
		nickNameField.setHorizontalAlignment(JTextField.CENTER);

		idField = new JTextField();
		idField.setHorizontalAlignment(JTextField.CENTER);
		idField.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				idOverlap = false;
				idOverlapLabel.setText("중복 검사 필요");
				idOverlapLabel.setForeground(new Color(236, 106, 94));
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}
		});

		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(JButton.CENTER);

		rePasswordField = new JPasswordField();
		rePasswordField.setHorizontalAlignment(JButton.CENTER);

		overlapCheckButton = new JButton("중복 검사");
		overlapCheckButton.setSize(new Dimension(10, 5));

		idOverlapLabel = new JLabel("영어, 숫자 필수 _ 선택 (3~20)");
		idOverlapLabel.setHorizontalAlignment(JLabel.CENTER);
		idOverlapLabel.setFont(new Font("중복 검사 결과", Font.BOLD | Font.ITALIC, 10));
//		idOverlapLabel.setOpaque(true);
		overlapCheckButton.addActionListener(new EventClickOverLap(idField, idOverlapLabel));

		cancleButton = new JButton("취소");
		// 창 종료되는 이벤트 리스너
		cancleButton.addActionListener(e -> {
			int answer = JOptionPane.showConfirmDialog(null, "회원가입을 취소하시겠습니까?", "회원가입 취소", JOptionPane.YES_NO_OPTION);
			if (answer == JOptionPane.YES_OPTION)
				dispose();
		});

		registerButton = new JButton("회원가입");
		registerButton.addActionListener(
				new EventClickOk(nickNameField, emailField, idField, passwordField, rePasswordField, this));

		passStrongLabel = new JLabel("대소문자, 숫자, 기호 (3~20)");
		passStrongLabel.setFont(new Font("", Font.BOLD | Font.ITALIC, 10));
		passStrongLabel.setOpaque(true);

		passStrongLabel.setHorizontalAlignment(JLabel.CENTER);

		passStrongProgressBar = new JProgressBar(0, 4);
		passStrongProgressBar.setOpaque(true);
		passStrongProgressBar.setStringPainted(true);
		passStrongProgressBar.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		passStrongProgressBar.setString("비밀번호 강도");
		// 비밀번호 강도 검사
		passwordField.addKeyListener(new PasswordStrongCheck(passwordField, passStrongProgressBar));
		rePasswordField.addKeyListener(new PasswordEqualCheck(passwordField, rePasswordField, passStrongLabel));
		rePasswordField.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER)
					registerButton.doClick();
			}
			@Override
			public void keyReleased(KeyEvent e) {
			}
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});

		// 구성요소 배치
		JPanel centerJPanel = new JPanel();
		centerJPanel.setLayout(new GridLayout(7, 2));
		centerJPanel.add(nicknameLabel);
		centerJPanel.add(nickNameField);
		centerJPanel.add(emailLabel);
		centerJPanel.add(emailField);
		centerJPanel.add(idLabel);
		centerJPanel.add(idField);
		centerJPanel.add(idOverlapLabel);
		centerJPanel.add(overlapCheckButton);
		// 중복 검사 결과 표시

		centerJPanel.add(passwordLabel);
//		centerJPanel.add(new JLabel("비밀번호 입력:"));
		centerJPanel.add(passwordField);
		centerJPanel.add(rePasswordLabel);
//		centerJPanel.add(new JLabel("비밀번호 재입력:"));
		centerJPanel.add(rePasswordField);
		centerJPanel.add(passStrongLabel);
		centerJPanel.add(passStrongProgressBar);

		JPanel footerJPanel = new JPanel();
		footerJPanel.setLayout(new FlowLayout());
		footerJPanel.add(cancleButton);
		footerJPanel.add(registerButton);

		container.add(centerJPanel, BorderLayout.CENTER);
		container.add(footerJPanel, BorderLayout.SOUTH);

		setTitle("Chat-Register");
		setSize(300, 300);
		// 연계 위치
		setLocationRelativeTo(null);
		// 크기 조절
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
//		pack();
		setVisible(true);

	}

	public static void main(String[] args) {
		new RegisterPage();
	}
}
