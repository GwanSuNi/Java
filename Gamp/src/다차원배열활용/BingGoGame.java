package 다차원배열활용;

import java.util.Scanner;

public class BingGoGame {

	public static void main(String[] args) {
		// 빙고판 크기 입력 3 <= N <= 8
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		
		if(N >= 3 && N <= 8) {
			// N*N 크기의 빙고판, 점검판 생성 bingo 클래스에서 구현
			BingGo binggo = new BingGo(N);
			// while로 N * 2 + 2 의 횟수만큼만 반복해서
			int count = N * 2 + 2;
			while (count > 0) {
				// 숫자 입력
				
				// 빙고 여부 점검
				
			}
			
			
		}
		
		
		scanner.close();
	}

}
