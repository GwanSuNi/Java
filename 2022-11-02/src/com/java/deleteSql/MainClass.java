package com.java.deleteSql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class MainClass {
	static String driver = "com.mysql.cj.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/lecture";
	static String uid = "####";
	static String pwd = "####";

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("삭제할 회원 입력: ");	
//		String delName = scanner.next();
		String delName = "'" + scanner.next() + "'";
		scanner.close();

		String query1 = "select * from member";
		// 홑따옴표에 주의 
//		String query2 = "delete from member where m_name = '" + delName + "'";
		String query2 = "delete from member where m_name = " + delName;

		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, uid, pwd);
			statement = connection.createStatement();

			int resultQuery = statement.executeUpdate(query2);
			if (resultQuery != 1) {
				System.out.println("회원 삭제 실패!");
			} else {
				System.out.println("회원 삭제 성공!");
			}

			resultSet = statement.executeQuery(query1);
			while (resultSet.next()) {
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

		} catch (Exception e) {
			e.printStackTrace();
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
