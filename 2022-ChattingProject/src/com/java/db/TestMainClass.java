package com.java.db;

import java.util.ArrayList;

public class TestMainClass {
	AccountDAO dao = new AccountDAO();
	long exp = (long) 10000;
	public static void main(String[] args) {
		TestMainClass t = new TestMainClass();
		
//		t.insertTest();
//		t.searchTest();
//		t.deleteTest();
//		t.updateNickNameTest();
//		t.updatePwTest();
		t.updateExpTest();
		t.printAllTest();

	}

	// 스키마 삽입 테스트
	void insertTest() {
		AccountDTO insertDto = new AccountDTO("id1", "pw1", "email1@ex.com", "아이디1", 0);
		if (dao.accountInsert(insertDto)) {
			System.out.println("삽입 성공");
		} else {
			System.out.println("삽입 실패");
		}
	}

	// 유저 검색 테스트
	void searchTest() {
		AccountDTO dto;
		try {
			dto = dao.findAccountById("id1");
			System.out.println(dto.getId());
			System.out.println(dto.getPw());
			System.out.println(dto.getEmail());
			System.out.println(dto.getNickName());
			System.out.println(dto.getExp());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 스키마 삭제 테스트
	void deleteTest() {
		try {
			if (dao.accountDelete(dao.findAccountById("id1"))) {
				System.out.println("삭제 성공");
			} else {
				System.out.println("삭제 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 비밀번호 수정 테스트
	void updatePwTest() {
		AccountDTO dto = null;
		try {
			dto = dao.findAccountById("test1");
			if (dao.accountUpdatePW(dto, new String(dto.getPw()), "ch")) {
				System.out.println("비밀번호 수정 성공");
			} else {
				System.out.println("비밀번호 수정 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 닉네임 수정 테스트
	void updateNickNameTest() {
		AccountDTO dto = null;
		try {
			dto = dao.findAccountById("test1");
			dto.setNickName("ChangedNickName");
			if (dao.accountUpdateNickName(dto)) {
				System.out.println("닉네임 수정 성공");
			} else {
				System.out.println("닉네임 수정 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 경험치 수정 테스트
	void updateExpTest() {
		AccountDTO dto = null;
		try {
			dto = dao.findAccountById("test1");
			dto.setExp(exp);
			if (dao.accountUpdateExp(dto)) {
				System.out.println("경험치 수정 성공");
			} else {
				System.out.println("경험치 수정 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 계정 출력 테스트
	void printAllTest() {
		AccountDAO dao = new AccountDAO();
		ArrayList<AccountDTO> dtos = dao.accountSelect();
		
		for (AccountDTO itemsDto : dtos) {
			System.out.println("ID: " + itemsDto.getId());
			System.out.println("PW: " + itemsDto.getPw());
			System.out.println("Email: " + itemsDto.getEmail());
			System.out.println("NickName: " + itemsDto.getNickName());
			System.out.println("UserExp: " + itemsDto.getExp());
			System.out.println("==========");
		}
	}
}
