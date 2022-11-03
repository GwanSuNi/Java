package com.java.ex.border;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class BorderLayoutSample extends JFrame {
	public BorderLayoutSample() {
		Container ct = getContentPane(); // 프레임으로부터 컨테이너 생성
		// 배치관리자 객체 생성  new BorderLayout(가로 간격, 세로 간격);
		BorderLayout b1 = new BorderLayout(10, 10); 
		ct.setLayout(b1); // 컨테이너에 배치관리자 설정
		// 동 서 남 북 센터 5가지의 위치 설정 가능
		ct.add(new JButton("right"), BorderLayout.EAST);
		ct.add(new JButton("left"), BorderLayout.WEST);
		ct.add(new JButton("top"), BorderLayout.NORTH);
		ct.add(new JButton("bottom"), BorderLayout.SOUTH);
		ct.add(new JButton("center"), BorderLayout.CENTER);
		setTitle("BorderLayout Sample"); // 창의 제목
		setSize(400, 300);	// 사이즈
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// X 버튼 클릭 시
		setVisible(true);	// 보여주기
	}
}
