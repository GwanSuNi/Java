package com.java.ex;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class JPanelSample2 extends JFrame {
	public JPanelSample2() {
		Container ct = getContentPane();
		ct.setLayout(new BorderLayout(3,3));
		
		JPanel jp1 = new JPanel();
		jp1.setLayout(new GridLayout(3, 1));
		jp1.add(new JRadioButton("Java"));
		jp1.add(new JRadioButton("JSP"));
		jp1.add(new JRadioButton("Spring"));
		
		JPanel jp2 = new JPanel();
		jp2.setLayout(new GridLayout(3, 1));
		jp2.add(new JButton("Java"));
		jp2.add(new JButton("JSP"));
		jp2.add(new JButton("Spring"));
		
		ct.add(jp1, BorderLayout.EAST);
		ct.add(jp2, BorderLayout.WEST);
		
		setTitle("JPanel Sample2");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
