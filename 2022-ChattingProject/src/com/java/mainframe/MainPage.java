package com.java.mainframe;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

import com.java.db.AccountDTO;
import com.java.mainframe.changeInfo.MyInfoPage;

@SuppressWarnings("serial")
public class MainPage extends JFrame {

	JButton makeRoomButton, quickEnterButton, rankingButton, chatEnterButton, myInfoJButton;
	JTextArea chatTextArea, clientTextArea;
	JList<String> userJList;
	DefaultListModel<String> model;
	JScrollPane scrollPane;
	Dimension frameSize, screenSize;

	public MainPage(AccountDTO userDto) {
		Container container = getContentPane();
		BorderLayout borderLayout = new BorderLayout(0, 10);
		container.setLayout(borderLayout);

		// 헤더 구성요소
//		makeRoomButton = new JButton("방 만들기");
//		makeRoomButton.setHorizontalAlignment(JButton.CENTER);
//		makeRoomButton.setBorderPainted(false);
//		makeRoomButton.addActionListener(e -> {
//			new MakeRoomPage();
//		});

//		quickEnterButton = new JButton("빠른 입장");
//		quickEnterButton.setHorizontalAlignment(JButton.CENTER);
//		quickEnterButton.setBorderPainted(false);
//		quickEnterButton.addActionListener(e -> {
//			// TODO: 아무 방 들어가기 액션
//		});

		rankingButton = new JButton("랭킹");
		rankingButton.setHorizontalAlignment(JButton.CENTER);
		rankingButton.setBorderPainted(false);
		rankingButton.addActionListener(e -> {
			new RankingPage();
		});

		// 센터 구성요소
		// 세로 스크롤 필요시, 가로 스크롤 사용 안함
		JPanel scrollJPanel = new JPanel();
		scrollJPanel.setLayout(new BorderLayout());
		scrollPane = new JScrollPane(scrollJPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//		scrollPane.setSize(810, 520);
		// 상하좌우 패딩 설정
		scrollPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
//		scrollPane.setViewportView(textArea); //데이터가 아래로 내려갈 경우에 아래로 자동으로 내려감

		// 좌측 구성요소
		model = new DefaultListModel<String>();
		model.addElement("--사용자 목록--");
		userJList = new JList<String>(model);
		// 단일 선택
		userJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// 내 정보 보기 버튼
		JPanel infoJPanel = new JPanel();
		myInfoJButton = new JButton("내 정보");
		myInfoJButton.setSize(new Dimension(20, 10));
		myInfoJButton.addActionListener(e -> {
			new MyInfoPage(userDto);
		});
		infoJPanel.add(myInfoJButton);

		// 푸터 구성요소
		chatTextArea = new JTextArea();
		chatTextArea.setEditable(false);

		clientTextArea = new JTextArea("--사용자--");
		clientTextArea.setEditable(false);

		// 구성요소 추가
		JPanel headerJPanel = new JPanel();
		headerJPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
//		headerJPanel.add(makeRoomButton);
//		headerJPanel.add(new JLabel("|"));
//		headerJPanel.add(quickEnterButton);
//		headerJPanel.add(new JLabel("|"));
		headerJPanel.add(rankingButton);

		// 좌측 패널
		JPanel leftJPanel = new JPanel();
		leftJPanel.setLayout(new BorderLayout(10, 10));
		leftJPanel.add(userJList, BorderLayout.WEST);
		// TODO: JList 연구
//		leftJPanel.add(clientTextArea, BorderLayout.WEST);
//		leftJPanel.add(myInfoJButton, BorderLayout.SOUTH);
		leftJPanel.add(infoJPanel, BorderLayout.SOUTH);

		// 중앙 패널
		JPanel centerJPanel = new JPanel();
		centerJPanel.setLayout(new BorderLayout());
		scrollPane.add(new TextArea(30 ,60));
//		for (int i = 0; i < 10; i++) {
//			scrollJPanel.add(new JButton("테스트용 버튼 " + i), BorderLayout.CENTER);
//		}
		centerJPanel.add(scrollPane);

//		scrollJPanel.add(new JLabel(), BorderLayout.EAST);

		// 하단 패널
		JPanel footerJPanel = new JPanel();
		footerJPanel.setLayout(new BorderLayout(10, 10));

		// 요소 배치
		container.add(headerJPanel, BorderLayout.NORTH);
		container.add(leftJPanel, BorderLayout.WEST);
		container.add(centerJPanel, BorderLayout.CENTER);

		setTitle("채팅방 [" + userDto.getNickName() + " (" + userDto.getId() + ")]");
		setSize(900, 600);
		// 연계 위치
//		setLocationRelativeTo(null);
		screenSizeLocation();
		// 크기 조절
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		pack();
		setVisible(true);
	}

	// 화면 중앙에 Frame 위치
	public void screenSizeLocation() {

		frameSize = getSize(); // 컴포넌트 크기
		screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 모니터 화면의 크기 구하기

		// (모니터화면 가로 - 프레임화면 가로) / 2, (모니터화면 세로 - 프레임화면 세로) / 2
		setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);

	}

//	public static void main(String[] args) {
//		new MainPage(new AccountDTO());
//	}
}
