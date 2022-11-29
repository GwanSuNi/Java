package com.java.mainframe;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainPage extends JFrame {
	
	JButton makeRoomButton, quickEnterButton, rankingButton, chatEnterButton;
	JLabel myInfoJLabel; // TODO: 클릭이벤트 없으면 버튼으로
	JList<String> userJList;
	
	
	
	public MainPage() {
		Container container = getContentPane();
		BorderLayout borderLayout = new BorderLayout(0, 10);
		container.setLayout(borderLayout);
		
		// 헤더 구성요소
		makeRoomButton = new JButton("방 만들기");
		makeRoomButton.setHorizontalAlignment(JButton.CENTER);
		makeRoomButton.setBorderPainted(false);
		
		quickEnterButton = new JButton("빠른 입장");
		quickEnterButton.setHorizontalAlignment(JButton.CENTER);
		quickEnterButton.setBorderPainted(false);
		
		rankingButton = new JButton("랭킹");
		rankingButton.setHorizontalAlignment(JButton.CENTER);
		rankingButton.setBorderPainted(false);
		
		// 센터 구성요소
		userJList = new JList<String>();
		myInfoJLabel = new JLabel("내 정보");
		
		// 구성요소 추가
		JPanel headerJPanel = new JPanel();
		headerJPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		headerJPanel.add(makeRoomButton);
		headerJPanel.add(new JLabel("|"));
		headerJPanel.add(quickEnterButton);
		headerJPanel.add(new JLabel("|"));
		headerJPanel.add(rankingButton);
		
		JPanel leftJPanel = new JPanel();
	
		
		// 중앙 패널
		JPanel centerJPanel = new JPanel();
		centerJPanel.setLayout(borderLayout);
		centerJPanel.add(userJList);
		centerJPanel.add(myInfoJLabel);
		
		
		// 요소 배치
		container.add(headerJPanel, BorderLayout.NORTH);
		container.add(leftJPanel, BorderLayout.WEST);
		container.add(centerJPanel, BorderLayout.CENTER);
		
		setTitle("Main Menu");
		setSize(900, 600);
		// 연계 위치
		setLocationRelativeTo(null);
		// 크기 조절
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		new MainPage();
	}
}
