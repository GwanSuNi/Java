package com.java.ex;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class MainClass {

	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		
		try {
			is = new FileInputStream("/Users/gwansuni/fileTest/test.txt");
			os = new FileOutputStream("/Users/gwansuni/fileTest/test_copy.txt");
			
			byte[] bs = new byte[5]; // 속도 향상을 위해 5byte 씩 연결
			
			while(true) {
				int count = is.read(bs); // 파일 읽기 처리
				if (-1 == count) {
					break;
				}
				os.write(bs, 0, count); // 파일 쓰기 처리 
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {	// 연결 끊기
			if (is != null) {
				try {
					is.close();
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				}
			}
			if ( os != null) {
				try {
					os.close();
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				}
			}
			// finally 구문을 아래로 단축 가능 사실 try-resource 구문 쓰면 됨
//			try {
//				if (is != null) is.close();
//				if (os != null) os.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
			
			System.out.println("종료");
		}
	}

}
