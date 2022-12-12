package com.java.register;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JSlider;

@SuppressWarnings("serial")
public class 슬라이더테스트 extends JFrame {

	JSlider slider;
	JProgressBar progressBar;
	
	public 슬라이더테스트() {
		Container container = getContentPane();
		BorderLayout borderLayout = new BorderLayout();
		container.setLayout(borderLayout);
		
//		slider = new JSlider(JSlider.HORIZONTAL, 0, 5, 0);
//		slider.setMajorTickSpacing(1);
//		slider.setPaintTrack(true);
//		container.add(slider, BorderLayout.CENTER);
		
		progressBar = new JProgressBar(0, 3);
		progressBar.setValue(4);
		progressBar.setOpaque(true);
		progressBar.setForeground(Color.RED);
		progressBar.setBackground(Color.green);
		progressBar.setSize(new Dimension(10, 20));
		progressBar.setBorder(BorderFactory.createLoweredBevelBorder());
		progressBar.setStringPainted(true);
		progressBar.setString("약함");
		
		container.add(progressBar);
		
		
		
		
		setTitle("슬라이더 테스트");
		setSize(300, 300);
		// 연계 위치
		setLocationRelativeTo(null);
		// 크기 조절
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new 슬라이더테스트();
	}
}
