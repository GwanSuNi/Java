package com.java.register;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class RegisterPage extends JFrame {
	JTextField nameField, nickNameField, idField;
	JPasswordField passwordField, rePasswordfField;
	JButton overLapCheckbButton, cancleButton, registerButton;
	JLabel passStrongJLabel, idOverlapLabel;
	
	public RegisterPage() {
		Container container = getContentPane();
		BorderLayout borderLayout = new BorderLayout();
		container.setLayout(borderLayout);
		container.setMinimumSize(new Dimension(800, 600));
		
		// label 생성 그리드 박스 내 글씨 정렬을 위해 변수 선언
		JLabel nameLabel, nicknameLabel, idLabel, passwordLabel, rePasswordLabel;
		nameLabel = new JLabel("이름 입력:");
		nameLabel.setHorizontalAlignment(JLabel.CENTER);
		nicknameLabel = new JLabel("닉네임 입력:");
		nicknameLabel.setHorizontalAlignment(JLabel.CENTER);
		idLabel = new JLabel("아이디 입력:");
		idLabel.setHorizontalAlignment(JLabel.CENTER);
		passwordLabel = new JLabel("비밀번호 입력:");
		passwordLabel.setHorizontalAlignment(JLabel.CENTER);
		rePasswordLabel = new JLabel("비밀번호 재입력:");
		rePasswordLabel.setHorizontalAlignment(JLabel.CENTER);
		
		nameField = new JTextField();
		nameField.setHorizontalAlignment(JTextField.CENTER);
		
		nickNameField = new JTextField();
		nickNameField.setHorizontalAlignment(JTextField.CENTER);
		
		idField = new JTextField();
		idField.setHorizontalAlignment(JTextField.CENTER);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(JButton.CENTER);
		passwordField.addActionListener(new EventInsertPass(passwordField, passStrongJLabel));
		
		rePasswordfField = new JPasswordField();
		rePasswordfField.setHorizontalAlignment(JButton.CENTER);
		
		overLapCheckbButton = new JButton("중복 검사");
		overLapCheckbButton.setSize(new Dimension(10, 5));
		
		idOverlapLabel = new JLabel("중복검사결과");
		idOverlapLabel.setHorizontalAlignment(JLabel.CENTER);
		idOverlapLabel.setFont(new Font("중복 검사 결과", Font.BOLD|Font.ITALIC, 10));
		overLapCheckbButton.addActionListener(new EventClickOverLap(idField, idOverlapLabel));
		// TODO: 글자색 변경
		
		
		cancleButton = new JButton("취소");
		// 창 종료되는 이벤트 리스너
		cancleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		registerButton = new JButton("회원가입");
		registerButton.addActionListener(new EventClickOk(nameField, nickNameField, idField, passwordField));
		
		passStrongJLabel = new JLabel("약함");
		passStrongJLabel.setFont(new Font("약함", Font.BOLD, 12));
		// TODO: 강력도에 따라 글자색 변경
		passStrongJLabel.setBackground(Color.red);
		passStrongJLabel.setHorizontalAlignment(JLabel.CENTER);
		
		// 구성요소 배치
		JPanel centerJPanel = new JPanel();
		centerJPanel.setLayout(new GridLayout(7, 2));
		centerJPanel.add(nameLabel);
//		centerJPanel.add(new JLabel("이름 입력:"));
		centerJPanel.add(nameField);
		centerJPanel.add(nicknameLabel);
//		centerJPanel.add(new JLabel("닉네임 입력:"));
		centerJPanel.add(nickNameField);
		centerJPanel.add(idLabel);
//		centerJPanel.add(new JLabel("아이디 입력:"));
		centerJPanel.add(idField);
		// 중복 검사 결과 표시
		centerJPanel.add(idOverlapLabel);
		centerJPanel.add(overLapCheckbButton);
		
		centerJPanel.add(passwordLabel);
//		centerJPanel.add(new JLabel("비밀번호 입력:"));
		centerJPanel.add(passwordField);
		centerJPanel.add(rePasswordLabel);
//		centerJPanel.add(new JLabel("비밀번호 재입력:"));
		centerJPanel.add(rePasswordfField);
		centerJPanel.add(new JLabel());
		centerJPanel.add(passStrongJLabel);
		
		
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		pack();
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new RegisterPage();
	}
}
