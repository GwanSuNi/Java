package backjoon_step2;

import java.util.Scanner;

public class BJ_1330 {

	public static void main(String[] args) {
		int a, b;
		String result;
		Scanner scanner = new Scanner(System.in);
		a = scanner.nextInt();
		b = scanner.nextInt();
		
		if (a==b) {
			result = "==";
		} else if (a > b) {
			result = ">";
		} else {
			result = "<";
		}
		System.out.println(result);
		scanner.close();
	}

}
