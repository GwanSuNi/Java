package com.java.ex;

import java.util.ArrayList;

import com.java.ex.DB.MemberDao;
import com.java.ex.DB.MemberDto;

public class MainClass {

	public static void main(String[] args) {
		MemberDao dao = new MemberDao();
		
		ArrayList<MemberDto> dtos  = dao.mSelect();
		
		for (MemberDto itemsDto : dtos) {
			System.out.println("ID: " + itemsDto.getId());
			System.out.println("PW: " + itemsDto.getPw());
			System.out.println("Name: " + itemsDto.getName());
			System.out.println("Email: " + itemsDto.getEmail());
			System.out.println("============");
		}
		
//		for (int i = 0; i < dtos.size(); i++) {
//			String id = "ID: " + dtos.get(i).getId();
//			String pw = "PW: " + dtos.get(i).getPw();
//			String name = "Name: " + dtos.get(i).getName();
//			String email = "Eamil: " + dtos.get(i).getEmail();
//			
//			System.out.println(id);
//			System.out.println(pw);
//			System.out.println(name);
//			System.out.println(email);
//			System.out.println("========");
//		}
		
	}
}
