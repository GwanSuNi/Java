package com.java.db;

import java.io.Serializable;

enum Info {
	JOIN, EXIT, SEND
}

@SuppressWarnings("serial")
public class AccountDTO implements Serializable {
	private String id, pw, email, nickName;
	private long exp; // unsigned 대응
	private Info command;
	

	public AccountDTO() {
	}
	
	public AccountDTO(String id, String pw, String email, String nickName, long exp) {
		this.id = id;
		this.pw = pw;
		this.email = email;
		this.nickName = nickName;
		this.exp = exp;
	}
	public Info getCommand() {
		return command;
	}
	
	public void setCommand(Info command) {
		this.command = command;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public long getExp() {
		return exp;
	}

	public void setExp(long exp) {
		this.exp = exp;
	}
}
