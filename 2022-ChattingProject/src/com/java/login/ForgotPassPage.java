package com.java.login;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ForgotPassPage extends JFrame {
	JTextField idField, emailField;
	JLabel idLabel, emailLabel;
	JButton okButton, cancleButton;
	
	public ForgotPassPage() {
		Container container = getContentPane();
		BorderLayout borderLayout = new BorderLayout();
		container.setLayout(borderLayout);
		
		idLabel = new JLabel("아이디:", JLabel.CENTER);
		emailLabel = new JLabel("이메일:", JLabel.CENTER);
		
		idField = new JTextField();
		idField.setHorizontalAlignment(JTextField.CENTER);
		
		emailField = new JTextField();
		emailField.setHorizontalAlignment(JTextField.CENTER);
		
		okButton = new JButton("비밀번호 찾기");
		okButton.addActionListener(new EventClickForgotPass(idField, emailField));
		
		cancleButton = new JButton("취소");
		cancleButton.addActionListener(e -> {
			dispose();
		});
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(2, 2));
		centerPanel.add(idLabel);
		centerPanel.add(idField);
		centerPanel.add(emailLabel);
		centerPanel.add(emailField);
		
		JPanel footerPanel = new JPanel();
		footerPanel.add(cancleButton);
		footerPanel.add(okButton);
		
		container.add(centerPanel, BorderLayout.CENTER);
		container.add(footerPanel, BorderLayout.SOUTH);
		
		setTitle("비밀번호 찾기");
		// 연계 위치
		setSize(320, 140);
		setLocationRelativeTo(null);
		// 크기 조절
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
//		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ForgotPassPage();
	}

}
