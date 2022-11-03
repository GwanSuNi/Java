package com.java.ex.event;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class EventSample extends JFrame {
	JLabel j1; // jLabel 객체를 멤버로 등록
	JButton jb1, jb2, jb3;
	public EventSample() {
		Container ct = getContentPane();
		ct.setLayout(new FlowLayout());
		
		jb1 = new JButton("눌러봐~!");
		jb2 = new JButton("아이언맨");
		jb3 = new JButton("스파이더맨");
		j1 = new JLabel("Click Button");
		
		// ActionListener를 준 다른 인스턴스를 추가 
		jb1.addActionListener(new EventClickButton(j1));
		jb2.addActionListener(new EventIronmanButton(j1));
		jb3.addActionListener(new EventSpidermanButton(j1));
		
		ct.add(jb1);
		ct.add(jb2);
		ct.add(jb3);
		ct.add(j1);
		
		setTitle("Event Sample");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
