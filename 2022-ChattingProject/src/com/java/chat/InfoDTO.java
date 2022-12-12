package com.java.chat;

import java.io.*;

enum Info {
	JOIN, EXIT, SEND
}

@SuppressWarnings("serial")
class InfoDTO implements Serializable{
	private String nickName;
	private String message;
	private String id;
	private Info command;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNickName(){
		return nickName;
	}
	public Info getCommand(){
		return command;
	}
	public String getMessage(){
		return message;
	}
	public void setNickName(String nickName){
		this.nickName= nickName;
	}
	public void setCommand(Info command){
		this.command= command;
	}
	public void setMessage(String message){
		this.message= message; 
	}
}