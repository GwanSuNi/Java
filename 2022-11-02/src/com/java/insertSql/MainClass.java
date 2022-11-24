package com.java.insertSql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		Scanner scanner = new Scanner(System.in);
		
		String query1 = "select * from member";
		String query2 = "insert into member value (?,?,?,?)";
		System.out.println("<<추가할 회원의 정보 입력>>");
		System.out.print("ID: ");
		String id = scanner.next();
		System.out.print("PW: ");
		String pw = scanner.next();
		System.out.print("이름: ");
		String name = scanner.next();
		System.out.print("이메일: ");
		String email = scanner.next();
		scanner.close();
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, uid, pwd);
			statement = connection.createStatement();
			
			preparedStatement = connection.prepareStatement(query2);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, pw);
			preparedStatement.setString(3, name);
			preparedStatement.setString(4, email);
			
			int resultQuery = preparedStatement.executeUpdate();
			if (resultQuery != 1)
				System.out.println("회원 등록 실패!");
			else
				System.out.println("회원 등록 성공!");
			
			
			resultSet = statement.executeQuery(query1);
			while (resultSet.next()) {
				String _id = resultSet.getString("m_id");
				String _pw = resultSet.getString("m_pw");
				String _name = resultSet.getString("m_name");
				String _email = resultSet.getString("m_email");

				System.out.println("ID: " + _id);
				System.out.println("PWD: " + _pw);
				System.out.println("이름: " + _name);
				System.out.println("이메일: " + _email);
				System.out.println("==========");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
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
