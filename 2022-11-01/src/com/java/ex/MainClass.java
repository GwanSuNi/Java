package com.java.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainClass {
	static String driver = "com.mysql.cj.jdbc.Driver";
	// "jdbc mysql을 사용하고 주소는 localhost 3306 포트의 lecture 스키마 사용
	static String url = "jdbc:mysql://localhost:3306/lecture";
	// 적절한 계정과 비밀번호로 수정
	static String uid = "####";
	static String pwd = "####";
	static String query = "select * from member";

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(driver); // Class 클래스의 forName 메서드로 드라이버 로드
			System.out.println("JDBC 드라이버 로드 성공");

			// DriverManager 클래스의 getConnection 메서드 사용해 접속
			connection = DriverManager.getConnection(url, uid, pwd);
			System.out.println("접속 성공");

			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				// resultSet의 getString(컬럼 이름);
				// 컬럼 속성이 숫라면 int ~~ = resultSet.getInt(컬럼 이름);
				String id = resultSet.getString("m_id");
				String pw = resultSet.getString("m_pw");
				String name = resultSet.getString("m_name");
				String email = resultSet.getString("m_email");

				System.out.println("ID: " + id);
				System.out.println("PWD: " + pw);
				System.out.println("이름: " + name);
				System.out.println("이메일: " + email);
				System.out.println("==========");
			}

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패");
		} catch (SQLException e) {
			System.out.println("접속 실패");
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
