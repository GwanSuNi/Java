package com.java.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AccountDAO {
	static String driver = "com.mysql.cj.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/ChatProject";
	static String uid = "testID";
	static String upw = "1234";

	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	PreparedStatement preparedStatement = null;
	private String query = null;

	public AccountDAO() {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 사용자 정보 반환
	public ArrayList<AccountDTO> accountSelect() {
		query = "SELECT * FROM User_Account";
		ArrayList<AccountDTO> dtos = new ArrayList<AccountDTO>();

		try {
			connection = DriverManager.getConnection(url, uid, upw);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				String id = resultSet.getString("UserId");
				String pw = resultSet.getString("UserPwd");
				String email = resultSet.getString("UserEmail");
				String nickName = resultSet.getString("UserNickName");
				long exp = resultSet.getLong("UserExp");

				AccountDTO dto = new AccountDTO(id, pw, email, nickName, exp);
				dtos.add(dto);
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
		return dtos;
	}

	// 사용자 정보 입력
	public boolean accountInsert(AccountDTO dto) {
		boolean result = false; // 실패시 false 반환
		try {
			connection = DriverManager.getConnection(url, uid, upw);
			preparedStatement = connection.prepareStatement("INSERT INTO User_Account VALUES(?,?,?,?,?)");
			preparedStatement.setString(1, dto.getId());
			preparedStatement.setString(2, dto.getPw());
			preparedStatement.setString(3, dto.getEmail());
			preparedStatement.setString(4, dto.getNickName());
			preparedStatement.setLong(5, dto.getExp());
			if (preparedStatement.executeUpdate() == 1)
				result = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	// 사용자 제거 (회원 탈퇴)
	public boolean accountDelete(AccountDTO dto) {
		boolean result = false;
		try {
			connection = DriverManager.getConnection(url, uid, upw);
			preparedStatement = connection
					.prepareStatement("DELETE FROM User_Account WHERE UserID = ? AND UserPwd = ?");
			preparedStatement.setString(1, dto.getId());
			preparedStatement.setString(2, dto.getPw());
			if (preparedStatement.executeUpdate() == 1)
				result = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	// 사용자 찾기 (아이디로 사용자 검색)
	public AccountDTO findAccountById(String id) throws SQLException, Exception {
		AccountDTO dto = null;
		try {
			connection = DriverManager.getConnection(url, uid, upw);
			preparedStatement = connection.prepareStatement(
					"Select UserPwd, UserEmail, UserNickName, UserExp from User_Account where UserId = ?");
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();

			dto = new AccountDTO();
			while (resultSet.next()) {
				String pw = resultSet.getString("UserPwd");
				String email = resultSet.getString("UserEmail");
				String nickName = resultSet.getString("UserNickName");
				long exp = resultSet.getLong("UserExp");
				dto.setId(id);
				dto.setPw(pw);
				dto.setEmail(email);
				dto.setNickName(nickName);
				dto.setExp(exp);
			}
			if (dto.getId() == null) {
				dto = null;
				throw new Exception("아이디 없음");
			}
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dto;
	}

	// 사용자 정보 수정 비밀번호
	public boolean accountUpdatePW(AccountDTO dto, String oldPw, String newPw) {
		boolean result = false;
		try {
			connection = DriverManager.getConnection(url, uid, upw);
			preparedStatement = connection.prepareStatement("UPDATE User_Account SET UserPwd = ? WHERE UserId = ? AND UserPwd = ?");
			preparedStatement.setString(1, newPw);
			preparedStatement.setString(2, dto.getId());
			preparedStatement.setString(3, oldPw);
			if (preparedStatement.executeUpdate() == 1) {
				return result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) 
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	
	// 사용자 정보 수정 닉네임
	public boolean accountUpdateNickName(AccountDTO dto) {
		boolean result = false;
		try {
			connection = DriverManager.getConnection(url, uid, upw);
			preparedStatement = connection.prepareStatement("UPDATE User_Account SET UserNickName = ? WHERE UserId = ?");
			preparedStatement.setString(1, dto.getNickName());
			preparedStatement.setString(2, dto.getId());
			if (preparedStatement.executeUpdate() == 1) {
				return result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) 
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	
	// 사용자 정보 수정 경험치
	public boolean accountUpdateExp(AccountDTO dto) {
		boolean result = false;
		try {
			connection = DriverManager.getConnection(url, uid, upw);
			preparedStatement = connection.prepareStatement("UPDATE User_Account SET UserExp = ? WHERE UserId = ?");
			preparedStatement.setLong(1, dto.getExp());
			preparedStatement.setString(2, dto.getId());
			if (preparedStatement.executeUpdate() == 1) {
				return result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) 
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
}
