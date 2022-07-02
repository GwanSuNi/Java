package 다차원배열활용;

import java.util.Scanner;
import Practice.Ansi;

public class BingGoGame implements Ansi {

	public static void main(String[] args) {
		// 빙고판 크기 입력 3 <= N <= 8
		Scanner scanner = new Scanner(System.in);
		System.out.print("빙고판 크기 입력 (3 ~ 8) > ");
		int n = scanner.nextInt();

		if (n >= 3 && n <= 8) {
			// N*N 크기의 빙고판, 점검판 생성 bingo 클래스에서 구현
			BingGo binggo = new BingGo(n);
			binggo.showStatus();
			// while로 N * 2 + 2 의 횟수만큼만 반복해서
			int count = n * 2 + 2;
			while (count > 0) {
				// 숫자 입력
				System.out.printf("1 ~ %d의 숫자 입력 > ", n * n);
				int number = scanner.nextInt();
				if (binggo.check(number)) {
					// 빙고 여부 점검
					binggo.showStatus();

					if (binggo.isBingGo()) {
						System.out.println(FONT_GREEN + "=== BINGGO! ===" + RESET);
						break;
					}
				} else {
					System.out.println(FONT_RED + "중복값 입력됨" + RESET);
					continue;
				}
				count--;
			} // end while
		} else {
			System.out.println(FONT_RED + "사이즈 오류" + RESET);
		}

		scanner.close();
	}

}
