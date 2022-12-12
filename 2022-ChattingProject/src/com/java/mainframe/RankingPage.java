package com.java.mainframe;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class RankingPage extends JFrame {

	JScrollPane scrollPane;
	JList<String> rankingList;
	DefaultListModel<String> model;
	JLabel textJLabel;
	String[] order = {"오름차순", "내림차순"};
	JRadioButton orderDESCButton, orderASCButton;
	
	public RankingPage() {
		Container container = getContentPane();
		BorderLayout borderLayout = new BorderLayout();
		container.setLayout(borderLayout);

		textJLabel = new JLabel("경험치 순위");
		
		// 라디오 버튼 생성 후 그룹 설정
		orderDESCButton = new JRadioButton("내림차순", true);
		orderASCButton = new JRadioButton("오름차순");
		ButtonGroup group = new ButtonGroup();
		group.add(orderASCButton);
		group.add(orderDESCButton);
		
		// 헤더 패널 구성요소 추가
		JPanel headerJPanel = new JPanel();
		headerJPanel.add(textJLabel);
		headerJPanel.add(orderDESCButton);
		headerJPanel.add(orderASCButton);
		
		// 리스트 항목 추가
		model = new DefaultListModel<String>();
		for (int i = 1; i < 20; i++) {
			model.addElement("랭킹" + i);
		}
		rankingList = new JList<String>(model);
		// 리스트 항목 중앙 정렬
		rankingList.setCellRenderer(new DefaultListCellRenderer() {
			public int getHorizontalAlignment() {
				return CENTER;
			}
		});
		// 스크롤 판넬에 리스트 추가
		scrollPane = new JScrollPane(rankingList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		
		// 컨테이너에 요소들 추가
		container.add(headerJPanel, BorderLayout.NORTH);
		container.add(scrollPane, BorderLayout.CENTER);

		setTitle("랭킹");
		setSize(250, 300);
		// 연계 위치
		setLocationRelativeTo(null);
		// 크기 조절
		setResizable(false);
		// TODO: HIDE_ON_CLOSE 로 변경해야함
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
//		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		new RankingPage();
	}
}
