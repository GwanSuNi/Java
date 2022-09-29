package com.java.ex;

import java.util.Scanner;
import com.java.ex.array.Array;

public class MainClass {

	public static void main(String[] args) {
		// 재시도 횟수 기록하는 변수
		int count = 0;
		
		// 사용자에게서 게임 크기 입력 
		Scanner inputSize = new Scanner(System.in);
		System.out.print("야구 게임 몇 자리를 할건지 입력(최대 4): ");
		String temp = inputSize.nextLine();
		Integer size = Integer.parseInt(temp);
		
		// 중복 검사를 포함해 문제 배열을 생성하는 과정
		int qNum[] = Array.makeArray(size);
		System.out.println("문제 생성 완료");
		// 테스트용 출력
		Test.show(qNum);

		
		// 정답용 스캐너
		Scanner input = new Scanner(System.in);
		// 정답용 배열
		int[] aNum = new int[size];
		// 정답 확인하는 플래그
		boolean correct = false;
		// 검사부
		while (!correct) {
			int ball = 0;
			int strike = 0;
			// 사용자 정답 맞추기
			System.out.print("[" + size + "]개의 숫자 입력: ");
			int tempInt = input.nextInt();
			count++;
			
			switch (size) {
			case 1:
			case 2: 
				aNum[0] = tempInt / 10;
				aNum[1] = tempInt % 10;
				break;
			case 3: 
				aNum[0] = tempInt / 100; // 100 자리
				aNum[1] = (tempInt - aNum[0] * 100) / 10; // 10 자리
				aNum[2] = tempInt % 10; // 1의 자리
				break;
			case 4:
				aNum[0] = tempInt / 1000; // 1000 자리
				aNum[1] = (tempInt-aNum[0] * 1000) / 100; // 100 자리
				aNum[2] = (tempInt - aNum[0] * 1000 - aNum[1] * 100) / 10; // 10 자리
				aNum[3] = tempInt % 10; // 1의 자리
			}

			// 모든 자리수 검사 (숫자가 존재하면 Ball, 위치가 동일하면 Strike, 해당하는게 모두 없으면 Out) 재시도 마다 count 증가
			for (int k = 0; k < size; k++) { // qNum[k]
				for (int l = 0; l < size; l++) { // aNum[l]
					if (k == l && qNum[k] == aNum[l]) {
						strike += 1;
					} else if (qNum[k] == aNum[l]) {
						ball += 1;
					} else {
						continue;
					}
				}
			}
			System.out.printf("%d차 도전 = | Ball: %d Srike : %d  |\n\n", count, ball, strike);

			if (strike == size) {
				correct = true;
				break;
			}
		} // end of while
		// 결과 출력
		System.out.println(count + "차 도전 후 정답입니다.");

		input.close();
		inputSize.close();
	}
	
	// 테스트 찍기용 클래스
	static class Test {
		static void show(int ary[]) {
			for (var item : ary) {
				System.out.printf("%2d", item);
			}
			System.out.println();
		}
	}

}
