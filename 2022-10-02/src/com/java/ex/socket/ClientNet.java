package com.java.ex.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientNet {
	Socket socket = null;
	PrintWriter writer = null;
	BufferedReader reader = null;
	
	public ClientNet() {
		try {
			socket = new Socket("localhost", 5000); // 포트번호 5000
			writer = new PrintWriter(socket.getOutputStream(), true);
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			String string = null;
			BufferedReader cReader = new BufferedReader(new InputStreamReader(System.in));
			
			while ((string = cReader.readLine()) != null) {
				writer.println(string);
				System.out.println("출력된 값: " + string);
			}
			
			writer.close();
			reader.close();
			cReader.close();
			socket.close();
		} catch (Exception e) {
		}
	}
	public static void main(String[] args) {
		new ClientNet();
	}
}
