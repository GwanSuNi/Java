package com.java.ex;

import Practice.Ansi;
public class MainClass implements Ansi {
	public static void main(String[] args) {
		for (int i = 2; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.printf("%2d *%2d =%3d", i, j, i * j);
				System.out.print(FONT_CYAN + " | " + RESET);
			}
			System.out.println();
		}
	}
}
