package com.java.ex.inetaddress;

import java.net.InetAddress;
import java.util.Scanner;

public class InetAddressEx {
	Scanner scan;
	
	public InetAddressEx() {
		System.out.print("HOST 입력 > ");
		scan = new Scanner(System.in);
		
		try {
			InetAddress inetAdd = InetAddress.getByName(scan.next());
			
			System.out.println("Server 이름: " + inetAdd.getHostName());
			System.out.println("Server IP: " + inetAdd.getHostAddress());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
