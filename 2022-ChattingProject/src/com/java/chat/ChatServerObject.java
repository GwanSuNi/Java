package com.java.chat;

import java.net.Socket;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.IOException;

@SuppressWarnings("serial")
class ChatServerObject extends JFrame {
	private ServerSocket serverSocket;
	private List<ChatHandlerObject> list;
	JButton startButton, stopButton;
	JLabel resultLabel;

	public ChatServerObject() {
		Container container = getContentPane();
		BorderLayout borderLayout = new BorderLayout(10, 10);
		container.setLayout(borderLayout);

		JPanel centerPanel = new JPanel();
		resultLabel = new JLabel("서버 구동 완료");
		centerPanel.add(resultLabel);
		container.add(centerPanel, BorderLayout.CENTER);

		setTitle("[서버 구동기]");
		setSize(200, 100);
		// 연계 위치
		setLocationRelativeTo(null);
		// 크기 조절
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		pack();
		setVisible(true);
		try {
			serverSocket = new ServerSocket(5555);
			System.out.println("서버 준비 완료");
			list = new ArrayList<ChatHandlerObject>();
			while (true) {
				Socket socket = serverSocket.accept();
				ChatHandlerObject handler = new ChatHandlerObject(socket, list); // 스레드를 생성한 것이랑 동일함! 떄문에 시자해주어야
				handler.start(); // 스레드 시작- 스레드 실행
				list.add(handler); // 핸들러를 담음( 이 리스트의 개수가 클라이언트의 갯수!!)
			} // while
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new ChatServerObject();
	}
}
//클라이언트가 동시에 채팅하기위해서 스레드가 필요하듯이 그 스레드를 동시에 받아들일 수 있는 서버 역시 스레드가 되어주어야 함!