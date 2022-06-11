package Practice;

import java.util.Scanner;

public class PrintStar {

	void printStar(String[][] args, int FirstLength, int SecondLength) {
		for (int i = 0; i < FirstLength; i++) {
			for (int j = 0; j < SecondLength; j++) {
				System.out.printf("%2s", args[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		String star = "*";
		String space = " ";
		boolean status = true;

		System.out.print("원하는 크기 입력 (홀수) > ");

		SetField setField = new SetField(); // 배열 성분 클래스 참조
		Scanner scanSize = new Scanner(System.in);
		setField.setLength(scanSize.nextInt());

		final int FirstLength = setField.getLength(); // 검증한 길이를 가져와서 지역 상수로 초기화
		final int SecondLength = setField.getLength();

		String field[][] = new String[FirstLength][SecondLength]; // 2차원 배열 생성

		System.out.print("== 원하는 모양 선택 ==\n 대각선 상\t(1)\n 대각선 하\t(2)\n Z모양\t(3)\n 테두리\t(4)\n");
		System.out.print(" 모래시계\t(5)\n 삼각형\t(6)\n 역삼각형\t(7)\n 마름모\t(8)\n 선택종료\t(-1)\n 원하는 모양 > ");

		// 모양 선택하기 위한 과정
		Scanner scanShape = new Scanner(System.in);
		int shape = scanShape.nextInt();
		
		if (shape == -1 || shape >= 1 && shape <= 8) {
			switch (shape) {
			case -1:
					status = false;
				break;
			case 1: // 대각선 오른쪽 위  
				for(int i = 0; i < FirstLength; i++) {
					for(int j = 0; j < SecondLength; j++) {
						if(i + j == field.length - 1)
							field[i][j] = star;
						else
							field[i][j] = space;
					}
				}
				break;
			case 2: // 대각선 오른쪽 아래 
				for(int i = 0; i < FirstLength; i++) {
					for(int j = 0; j < SecondLength; j++) {
						if(i == j)
							field[i][j] = star;
						else 
							field[i][j] = space;
					}
				}
				break;
			case 3: // Z모양 
				for(int i = 0; i < FirstLength; i++) {
					for(int j = 0; j< SecondLength; j++) {
						if(i == 0 || i == field.length - 1 || i + j == field.length - 1)
							field[i][j] = star;
						else
							field[i][j] = space;
					}
				}
				break;
			case 4: // 테두리
				for(int i = 0; i < FirstLength; i++) {
					for(int j = 0; j < SecondLength; j++) {
						if(i == 0 || j == 0 || i == FirstLength - 1 || j == SecondLength - 1) {
							field[i][j] = star;
						}
						else
							field[i][j] = space;
					}
				}
				break;
			case 5: // 모래시계
				for (int i = 0; i < FirstLength; i++) {
					for (int j = 0; j < SecondLength; j++) {
						if (i == 0 || i == field.length - 1 || i == j || i + j == field.length - 1)
							field[i][j] = star;
						else
							field[i][j] = space;

					}
				}
				break;
			case 6: // 삼각형
				for(int i = 0; i < FirstLength; i++) {
					for(int j = 0; j < SecondLength; j++) {
						if(i + j == field.length / 2 || j - i == field.length / 2 || i == field.length / 2)
							field[i][j] = star;
						else
							field[i][j] = space;
					}
				}
				break;
			case 7: // 역삼각형
				for(int i = 0; i < FirstLength; i++) {
					for(int j = 0; j < SecondLength; j++) {
						if(i - j == field.length / 2 ||  i + j == ((field.length) / 2) * 3 || i == field.length / 2)
							field[i][j] = star;
						else
							field[i][j] = space;
					}
				}
				break;
			case 8: // 마름모
				for(int i = 0; i < FirstLength; i++) {
					for(int j = 0; j < SecondLength; j++) {
						if(i - j == field.length / 2 || i + j == ((field.length) / 2) * 3 || i + j == field.length / 2 || j - i == field.length / 2)
							field[i][j] = star;
						else
							field[i][j] = space;
					}
				} // (field.length+ i + j) % 5 == 1 
				break;
			}
		} else {
			status = false;
			System.out.println("잘못된 입력");
			// 프로그램 종료 혹은 반복
		}
		
		scanSize.close();
		scanShape.close();
		
		PrintStar printstar = new PrintStar(); // static이 클래스당 하나만 있어야된다면 main이 static이라 비추?
		if(status)
			printstar.printStar(field, FirstLength, SecondLength); // 출력 메소드
		else
			System.out.println("종료");
	}

}
