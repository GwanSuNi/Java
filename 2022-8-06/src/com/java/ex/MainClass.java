package com.java.ex;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		String song = "~~할테죠\n" + "~한 사람입니다\n" + "~어쩌구 저쩌구\n";
		
		char[] input = new char[song.length()];
		song.getChars(0, song.length(), input, 0); // 문자열을 문자 배열로 생성 0부터 시작해서 없을 때까지 길이만큼 input에
		System.out.print("파일명 입력(.txt는 생략): ");
		String fileName = sc.next() + ".txt";
		FileWriter fw = new FileWriter(fileName);
		fw.write(song);
		fw.close();
		System.out.println(fileName + "파일이 생성되었습니다.");
		
		System.out.print("읽어들일 파일명 입력(.txt는 생략): ");
		String inputFileName = sc.next() + ".txt";
		FileReader fr = new FileReader(inputFileName);
		int ch;
		while((ch=fr.read()) != -1) { // 파일에서 한 문자씩 읽어들임
			System.out.println((char)ch); // 읽은 문자 출력
		}
		
		fr.close();
		sc.close();
	}

}
