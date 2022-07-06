package 자료구조를위한테스트;

import java.util.Scanner;
import java.util.StringTokenizer;

public class TestStringTokenizer {

	public static void main(String[] args) {
		// 문자열 한 줄 읽기
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();

		// 토큰들로 분리
		// StringTokenizer(String, delim, return?);
		StringTokenizer tokens = new StringTokenizer(s, "+-*/", true);

		// 분리한 토큰들을 출력
		while (tokens.hasMoreTokens()) { // 다음 토큰이 있으면
			String token = tokens.nextToken();
			System.out.println(token);
		}

		scanner.close();
	}

}
