package com.java.ex.grid;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GridLayoutSample extends JFrame {
	public GridLayoutSample() {
		Container ct = getContentPane();
		// grid 배치관리자 객체 생성 GridLayout(행, 열, 가로 간격, 세로 간격);
		GridLayout g1 = new GridLayout(4, 5, 10, 10);
		ct.setLayout(g1);	// 컨테이너 배치관리자 생성
		for (int i = 1; i <= 20; i++) {	// 버튼 생성
			ct.add(new JButton("버튼" + i));
		}
		setTitle("GridLayout Sample");
		setSize(800,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// X 버튼 클릭 시
		setVisible(true);
	}
}
