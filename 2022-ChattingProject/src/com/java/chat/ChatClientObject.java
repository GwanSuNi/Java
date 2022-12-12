package com.java.chat;

import javax.swing.*;

import com.java.db.AccountDTO;
import com.java.mainframe.changeInfo.MyInfoPage;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

@SuppressWarnings("serial")
public class ChatClientObject extends JFrame implements ActionListener, Runnable {
	private JTextArea output;
	private JTextField input;
	private JButton sendBtn, myInfoButton;
	private Socket socket;
	private ObjectInputStream reader = null;
	private ObjectOutputStream writer = null;
	private String nickName;
	AccountDTO accountDTO = null;

	public ChatClientObject(AccountDTO accountDTO) {
		this.accountDTO = accountDTO;
		
		// 상단
		JPanel top = new JPanel();
		top.setLayout(new FlowLayout());
		myInfoButton = new JButton("| 내 정보 |");
		myInfoButton.setBorder(BorderFactory.createEmptyBorder());
		myInfoButton.addActionListener(e->{
			new MyInfoPage(accountDTO);
		});
		top.add(myInfoButton);
		
		// 센터에 TextArea만들기
		output = new JTextArea();
		output.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		output.setEditable(false);
		JScrollPane scroll = new JScrollPane(output);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // 항상 스크롤바가 세로로 떠있음

		// 하단에 버튼과 TextArea넣기
		JPanel bottom = new JPanel();
		bottom.setLayout(new BorderLayout());
		input = new JTextField();
		sendBtn = new JButton("전송");

		bottom.add("Center", input); // 센터에 붙이기
		bottom.add("East", sendBtn); // 동쪽에 붙이기
		// container에 붙이기
		Container c = this.getContentPane();
		c.add("North", top);
		c.add("Center", scroll); // 센터에 붙이기
		c.add("South", bottom); // 남쪽에 붙이기
		// 윈도우 창 설정
		setBounds(300, 300, 300, 300);
		setVisible(true);
		setTitle(accountDTO.getNickName() + "(" + accountDTO.getId() + ") 님의 채팅");

		// 윈도우 이벤트
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				// System.exit(0);
				try {
					// InfoDTO dto = new InfoDTO(nickName,Info.EXIT);
					InfoDTO dto = new InfoDTO();
					dto.setNickName(nickName);
					dto.setCommand(Info.EXIT);
					writer.writeObject(dto); // 역슬러쉬가 필요가 없음
					writer.flush();
				} catch (IOException io) {
					io.printStackTrace();
				}
			}
		});
	}

	public void service() {
		// 서버 IP 입력받기
		String serverIP = "127.0.0.1";
		if (serverIP == null || serverIP.length() == 0) { // 만약 값이 입력되지 않았을 때 창이 꺼짐
			System.out.println("서버 IP가 입력되지 않았습니다.");
			System.exit(0);
		}
		// 닉네임 받기
		nickName = accountDTO.getNickName();
		if (nickName == null || nickName.length() == 0) {
			nickName = "Admin";
		}
		try {
			socket = new Socket(serverIP, 5555);
			// 에러 발생
			reader = new ObjectInputStream(socket.getInputStream());
			writer = new ObjectOutputStream(socket.getOutputStream());
			System.out.println("전송 준비 완료!");
		} catch (UnknownHostException e) {
			System.out.println("서버를 찾을 수 없습니다.");
			e.printStackTrace();
			System.exit(0);
		} catch (IOException e) {
			System.out.println("서버와 연결이 안되었습니다.");
			e.printStackTrace();
			System.exit(0);
		}
		try {
			// 서버로 닉네임 보내기
			InfoDTO dto = new InfoDTO();
			dto.setCommand(Info.JOIN);
			dto.setNickName(nickName);
			writer.writeObject(dto); // 역슬래쉬 필요 없음
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 스레드 생성
		Thread t = new Thread(this);
		t.start();
		input.addActionListener(this);
		sendBtn.addActionListener(this); // 엑션 이벤트 추가
	}

	// 스레드 오버라이드
	@Override
	public void run() {
		// 서버로부터 데이터 받기
		InfoDTO dto = null;
		while (true) {
			try {
				dto = (InfoDTO) reader.readObject();
				if (dto.getCommand() == Info.EXIT) { // 서버로부터 내 자신의 exit를 받으면 종료됨
					reader.close();
					writer.close();
					socket.close();
					System.exit(0);
				} else if (dto.getCommand() == Info.SEND) {
					nickName = accountDTO.getNickName();
					output.append(dto.getMessage() + "\n");
					int pos = output.getText().length();
					output.setCaretPosition(pos);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	// ActionPerformed
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			// 서버로 보냄
			// JTextField값을 서버로보내기
			// 버퍼 비우기
			String msg = input.getText();
			InfoDTO dto = new InfoDTO();
			// dto.setNickName(nickName);
			if (msg.equals("exit")) {
				dto.setCommand(Info.EXIT);
			} else {
				dto.setCommand(Info.SEND);
				dto.setMessage(msg);
				dto.setNickName(nickName);
				dto.setId(accountDTO.getId());
			}
			writer.writeObject(dto);
			writer.flush();
			input.setText("");

		} catch (IOException io) {
			io.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ChatClientObject(new AccountDTO()).service();
	}
}
//동시 채팅을 위해 쓰레드를 생성해주어야 함