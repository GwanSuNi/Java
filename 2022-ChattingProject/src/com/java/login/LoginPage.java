package com.java.login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.java.register.RegisterPage;

@SuppressWarnings("serial")
public class LoginPage extends JFrame implements Runnable {
	JTextField idField;
	JPasswordField passwordField;
	JButton loginButton, signInButton, forgotButton;
	JLabel logoJLabel, passResultLabel;
	protected static boolean status = false;

	public LoginPage() {
		Container container = getContentPane();
		BorderLayout borderLayout = new BorderLayout(10, 10);
		container.setLayout(borderLayout);
//		container.setMinimumSize(new Dimension(400, 300));
		
		logoJLabel = new JLabel("채팅 프로그램", JLabel.CENTER);
		logoJLabel.setFont(new Font(getName(), Font.BOLD, 16));
		
		idField = new JTextField();
		idField.setSize(50, 20);
		idField.setHorizontalAlignment(JButton.CENTER);
		
		passwordField = new JPasswordField();
		passwordField.setPreferredSize(new Dimension(50, 20));
		passwordField.setHorizontalAlignment(JButton.CENTER);
		passwordField.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER)
					loginButton.doClick();
			}
			@Override
			public void keyReleased(KeyEvent e) {
			}
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
//		passwordField.setBorder(BorderFactory.createEmptyBorder());
		
		loginButton = new JButton("로그인");
		passResultLabel = new JLabel("");
		passResultLabel.setHorizontalAlignment(JLabel.CENTER);
		passResultLabel.setFont(new Font("비밀번호 결과", Font.BOLD | Font.ITALIC, 10));
		passResultLabel.setForeground(new Color(236, 106, 94));
		loginButton.addActionListener(new EventClickLogin(idField, passwordField, passResultLabel, this));
		
		signInButton = new JButton("회원가입");
		signInButton.addActionListener( e -> {
			new RegisterPage();
		});
		
		forgotButton = new JButton("Forgot Password?");
		forgotButton.addActionListener(e -> {
			new ForgotPassPage();
		});
		forgotButton.setToolTipText("비밀번호를 잊으셨다면 누르세요");
		forgotButton.setBorderPainted(false);
		forgotButton.setFont(new Font("비밀번호찾기", Font.ITALIC, 10));
//		forgotButton.setHorizontalAlignment(JButton.RIGHT);

		
		// 구성요소 추가
		JPanel headerJPanel = new JPanel();
		headerJPanel.setLayout(new GridLayout());
		// TODO: 로고 이미지 공간 추가
		headerJPanel.add(logoJLabel, BorderLayout.CENTER);

		JPanel centerJPanel = new JPanel();
		centerJPanel.setLayout(new GridLayout(3, 3, 2, 2));
		// 아이디 입력칸
		centerJPanel.add(new JLabel("아이디:", JLabel.CENTER));
		centerJPanel.add(idField);
		// 비밀번호 입력칸
		centerJPanel.add(new JLabel("비밀번호:", JLabel.CENTER));
		centerJPanel.add(passwordField);
		centerJPanel.add(forgotButton);
		centerJPanel.add(passResultLabel);

		JPanel footerJPanel = new JPanel();
		footerJPanel.setLayout(new FlowLayout());
		footerJPanel.add(signInButton);
		footerJPanel.add(loginButton);

		container.add(headerJPanel, BorderLayout.NORTH);
		container.add(centerJPanel, BorderLayout.CENTER);
		container.add(footerJPanel, BorderLayout.SOUTH);

		setTitle("Chat-LogIn");
		setSize(400, 300);
		// 연계 위치
		setLocationRelativeTo(null);
		// 크기 조절
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		
		// 스레드화
		Thread t = new Thread(this);
		t.start();
	}

	public static void main(String[] args) {
		new LoginPage();
	}

	@Override
	public void run() {
		
	}

}
