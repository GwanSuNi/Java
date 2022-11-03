package com.java.ex;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class FlowLayoutSample extends JFrame {
	public FlowLayoutSample() {
		Container ct = getContentPane(); // 프레임으로부터 컨테이너 생성
		// 배치관리자 객체 생성  new FlowLayout(시작 위치, 가로 간격, 세로 간격)
		FlowLayout f1 = new FlowLayout(FlowLayout.LEFT, 15, 10); 
		ct.setLayout(f1); // 컨테이너에 배치관리자 설정
		for (int i = 1; i <= 15; i++) {	// 버튼 생성
			ct.add(new JButton("버튼" + i));
		}
		setTitle("FlowLayout Sample"); // 창의 제목
		setSize(400, 300);	// 사이즈
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// X 버튼 클릭 시
		setVisible(true);	// 보여주기
	}
}
