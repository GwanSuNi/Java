package com.java.ex.url;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class URLEx {

	public URLEx() {
		String code = null;
		System.out.print("주소 입력 > ");
		Scanner scanner = new Scanner(System.in);
		String address = scanner.next();

		try {
			// 주소를 입력 받고 해당 URL을 관리하는 클래스
			URL url = new URL(address);
			// URL을 통해서 해당 사이트에 접속
			URLConnection connection = url.openConnection();
			// 해당 주소의 소스 보기
			BufferedReader webData = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			// 저장 경로의 file.html 소스 보기
			FileWriter fileWriter = new FileWriter("src/com/java/ex/url/File.html", false);

			while ((code = webData.readLine()) != null) {
				fileWriter.write(code);
			}
			System.out.println("끝!");

			fileWriter.close();
			webData.close();
			scanner.close();

		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public static void main(String[] args) {
		new URLEx();
	}

}
