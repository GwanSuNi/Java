package com.java.mainframe;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class MakeRoomPage extends JFrame {

	JTextField roomNameField;
	JComboBox<String> maxPlayerNumComboBox, roundComboBox, roundTimeComboBox;
	JButton cancleButton, okButton;

	String[] maxPlayers = { "1", "2", "3", "4", "5", "6", "7", "8" };
	String[] roundCount = { "1", "2", "3", "4", "5" };
	String[] roundTime = { "10초", "30초", "60초", "90초" };

	public MakeRoomPage() {
		Container container = getContentPane();
		BorderLayout borderLayout = new BorderLayout();
		container.setLayout(borderLayout);

		// label 생성 그리드 박스 내 글씨 정렬을 위해 변수 선언
		JLabel roomNameLabel, maxPlayerNumLabel, roundLabel, roundTimeLabel;
		roomNameLabel = new JLabel("방 제목", JLabel.CENTER);
		maxPlayerNumLabel = new JLabel("플레이어 수", JLabel.CENTER);
		roundLabel = new JLabel("라운드 수", JLabel.CENTER);
		roundTimeLabel = new JLabel("라운드 시간", JLabel.CENTER);

		roomNameField = new JTextField();
		roomNameField.setHorizontalAlignment(JTextField.CENTER);

		cancleButton = new JButton("취소");
		cancleButton.addActionListener(e -> {
			dispose();
		});

		okButton = new JButton("방 만들기");
		// TODO: 방 만드는 액션 추가

		maxPlayerNumComboBox = new JComboBox<String>(maxPlayers);
		roundComboBox = new JComboBox<String>(roundCount);
		roundTimeComboBox = new JComboBox<String>(roundTime);

		// 구성요소 배치
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(5, 2));
		centerPanel.add(roomNameLabel);
		centerPanel.add(roomNameField);
		centerPanel.add(maxPlayerNumLabel);
		centerPanel.add(maxPlayerNumComboBox);
		centerPanel.add(roundLabel);
		centerPanel.add(roundComboBox);
		centerPanel.add(roundTimeLabel);
		centerPanel.add(roundTimeComboBox);

		JPanel footerPanel = new JPanel();
		footerPanel.setLayout(new FlowLayout());
		footerPanel.add(cancleButton);
		footerPanel.add(okButton);

		container.add(centerPanel, BorderLayout.CENTER);
		container.add(footerPanel, BorderLayout.SOUTH);

		setTitle("방 만들기");
		setSize(300, 200);
		// 연계 위치
		setLocationRelativeTo(null);
		// 크기 조절
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
//		pack();
		setVisible(true);

	}

	public static void main(String[] args) {
		new MakeRoomPage();
	}
}
