package backjoon_step2;

import java.util.Scanner;

class BJ_2753 {

	public static void main(String[] args) {
		int year;
		Scanner scanner = new Scanner(System.in);
		year = scanner.nextInt();
		scanner.close();
//		if (year % 4 == 0) {
//			if (year % 100 != 0 || year % 400 == 0) {
//				System.out.println(1);
//				return;
//			}
//		}
//		System.out.println(0);
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

}
