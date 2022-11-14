package com.java.ex.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerNet {
	ServerSocket serverSocket = null; // 전선
	Socket socket = null; // 전선 끝의 소켓
	PrintWriter writer = null; // 읽고 쓰게 하는 I/O Stream
	BufferedReader reader = null;
	String lineString;

	public ServerNet() {
		try {
			serverSocket = new ServerSocket(5000); // 포트 번호 5000 (프로그램 식별할 수 있는 ID)

			while (true) {
				// 소켓에 서버 소켓 접속
				socket = serverSocket.accept();
				System.out.println("Client에서 통신 요청 접수!");

				// 소켓을 통해 I/O Stream이 통함
				writer = new PrintWriter(socket.getOutputStream(), true);
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

				while ((lineString = reader.readLine()) != null) {
					writer.write(lineString);
					System.out.println("입력된 값: " + lineString);
				}

				writer.close();
				reader.close();
				socket.close();
			}
		} catch (Exception e) {
		}
	}

	public static void main(String[] args) {
		new ServerNet();
	}
}
