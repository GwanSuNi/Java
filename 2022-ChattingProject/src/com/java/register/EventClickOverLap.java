package com.java.register;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.java.db.AccountDAO;

public class EventClickOverLap implements ActionListener {
	JTextField id;
	JLabel l1;
	String regId= "^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9_]{3,20}$"; // 영어,숫자는 필수 기호는 _만 허용
	private boolean patternedId = false;
	
	public EventClickOverLap(JTextField id, JLabel l1) {
			this.id = id;
			this.l1 = l1;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!id.getText().equals("")) {
//			l1.setText("OK");
			patternedId = Pattern.matches(regId, id.getText());
			if (!patternedId) {
				l1.setText("아이디 조건에 맞지 않음");
				l1.setForeground(new Color(236, 106, 94));
				return;
			}
			
			// 중복 검사 하는 과정
			AccountDAO dao = new AccountDAO();
			try {
				if (dao.findAccountById(id.getText()) != null) { // 검색 결과가 있으면
					String idString = dao.findAccountById(id.getText()).getId();
					if(idString.compareTo(id.getText()) == 0) { // TODO: equals() 써도 대소문자 구별을 안해줌
						l1.setText("아이디 중복");
						l1.setForeground(new Color(245, 191, 79));						
					}
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (Exception e1) { // findAccountById()에서 Exception을 던지면 검색 결과가 없다는 뜻
				l1.setText("사용 가능한 아이디");
				l1.setForeground(new Color(98, 197, 84));
				RegisterPage.idOverlap = true;
			}
		} else {
			l1.setText("아이디를 입력해주세요");
			l1.setForeground(new Color(236, 106, 94));
		}
	}
}
