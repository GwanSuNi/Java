package com.java.ex;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		String name[] = { "철수", "영희", "진구", "윤우", "관형" };
		int iAry[] = new int[5];

		int totalHeight = 0, maxHeight = 0, maxHeightIndex = 0;
		int minHeight = 0, minHeightIndex = 0;

		Scanner scanner = new Scanner(System.in);

		for (int i = 0; i < name.length; i++) {
			System.out.print(name[i] + " 친구의 키를 입력하세요(CM) > ");
			iAry[i] = scanner.nextInt();
			totalHeight += iAry[i];

			if (iAry[i] > maxHeight) {
				maxHeight = iAry[i];
				maxHeightIndex = i;
			}
			
			minHeight = iAry[minHeightIndex];
			if (iAry[i] < minHeight) {
				minHeight = iAry[i];
				minHeightIndex = i;
			}
		}

		System.out.printf("친구들의 평균 신장은 %.1f\n", (double) totalHeight / name.length);
		System.out.printf("최장신의 이름: %s | 키: %d\n", name[maxHeightIndex], maxHeight);
		System.out.printf("최단신의 이름: %s | 키: %d\n", name[minHeightIndex], minHeight);
		
	}

}
