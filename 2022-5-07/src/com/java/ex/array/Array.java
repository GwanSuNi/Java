package com.java.ex.array;

import java.util.Random;

public final class Array {
	static int[] qNum;
	
	public static int[] makeArray(int size) {
		if (size > 5) {
			System.out.println("5 이상의 값은 불가능 다시 하세요");
			return new int[0];
		}
		qNum = new int[size];
		System.out.println("["+ size + "] 크기의 배열 생성");
		
		Random random = new Random();
		int temp;
		int m = 0;
		// 문제를 위한 배열 생성
		while (m < qNum.length) {
			// 이 방식은 문제가 생길 수 있음
			temp = random.nextInt(10);
			for (int j = 0; j <= m; j++)
				if (temp == qNum[j])
					continue;
			qNum[m] = temp;
			m++;
		}
		return qNum;
	}
	
}
