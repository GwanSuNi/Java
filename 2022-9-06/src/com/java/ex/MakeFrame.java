package com.java.ex;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.List;

@SuppressWarnings("serial")
public class MakeFrame extends Frame implements ActionListener {
	private List list;
	private Panel panel;
	private TextField textField;
	private Button okButton;
	private Button exitButton;

	public MakeFrame() {
		list = new List();
		panel = new Panel();
		textField = new TextField(20); // 20 글자 가능
		okButton = new Button("OK");
		exitButton = new Button("Exit");

		// 화면 구성을 동서남북, 센터를 사용하는 BorderLayout 사용
		setLayout(new BorderLayout());
		add(panel, BorderLayout.NORTH);
		add(list, BorderLayout.CENTER);
		panel.add(new Label("Write:")); // Lable 추가
		panel.add(textField);
		panel.add(okButton);
		panel.add(exitButton);

		// 이 클래스에서 구현된 actionPerformed() 실행할 것
		okButton.addActionListener(this);
		exitButton.addActionListener(this);

		// 윈도우 틀에 대한 리스너
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
	}

	// ActionLister 메서드
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == okButton) {
			list.add(textField.getText());
		} else if (e.getSource() == exitButton) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}

}
