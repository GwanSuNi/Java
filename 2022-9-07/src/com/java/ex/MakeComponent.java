package com.java.ex;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class MakeComponent extends JFrame implements ActionListener {
	JPanel jPanel;
	JLabel jLabel;
	JLabel jLabelBlank;
	JButton jButton;
	JButton jButtonExit;
	JTextField jTextField;
	JComboBox<String> jComboBox;
	JCheckBox jCheckBox;
	String[] items = { "홍길동", "김철수", "이영희" };

	public MakeComponent() {
		// AWT에서와 다르게 윈도우 틀에 대한 리스너와 다르게 Swing에서는 한 줄로 처리 가능
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jPanel = (JPanel) getContentPane();
		// 흐름에 따라서 처리
		jPanel.setLayout(new FlowLayout());
		jLabel = new JLabel("라벨");
		jButton = new JButton("버튼");
		jTextField = new JTextField(20);
		jComboBox = new JComboBox<String>(items);
		jCheckBox = new JCheckBox("체크박스");
		jLabelBlank = new JLabel();
		jButtonExit = new JButton("Exit");

		jPanel.add(jLabel);
		jPanel.add(jButton);
		jPanel.add(jTextField);
		jPanel.add(jComboBox);
		jPanel.add(jCheckBox);
		jPanel.add(jLabelBlank);
		jPanel.add(jButtonExit);

		jLabel.setPreferredSize(new Dimension(50, 50));
		jButton.setPreferredSize(new Dimension(100, 50));
		jTextField.setPreferredSize(new Dimension(300, 50));
		jComboBox.setPreferredSize(new Dimension(100, 50));
		jCheckBox.setPreferredSize(new Dimension(100, 50));
		jLabelBlank.setPreferredSize(new Dimension(200, 50));
		jButtonExit.setPreferredSize(new Dimension(100, 50));

		jButton.addActionListener(this);
		jButtonExit.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jButton) {
			jLabelBlank.setText(jTextField.getText());
		} else if (e.getSource() == jButtonExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}

}
