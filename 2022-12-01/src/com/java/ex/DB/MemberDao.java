package com.java.ex.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MemberDao {
	static String driver = "com.mysql.cj.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/lecture";
	static String uid = "####";
	static String upw = "####";

	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	private String query = null;

	// 생성할 때 드라이버 로드
	public MemberDao() {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Select 쿼리를 위한 메서드
	public ArrayList<MemberDto> mSelect() {
		query = "select * from member";
		ArrayList<MemberDto> dtos = new ArrayList<MemberDto>();

		try {
			connection = DriverManager.getConnection(url, uid, upw);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			
			while (resultSet.next()) {
				String id = resultSet.getString("m_id");
				String pw = resultSet.getString("m_pw");
				String name = resultSet.getString("m_name");
				String email = resultSet.getString("m_email");
				
				MemberDto dto = new MemberDto(id, pw, name, email);
				dtos.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) resultSet.close();
				if (statement != null) resultSet.close();
				if (connection != null) connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dtos;
	}
}
