package backjoon_step1;

import java.util.Scanner;

class BJ_3003 {

	public static void main(String[] args) {
		int[] piece = new int[6];
		int[] standard = { 1, 1, 2, 2, 2, 8 };
		int[] result = new int[6];
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < piece.length; i++) {
			piece[i] = scanner.nextInt();
			result[i] = standard[i] - piece[i];
		}
		int index = 0;
		for(int item : result) {
			index++;
			if (index == result.length)
				System.out.println(item);
			else
				System.out.print(item + " ");
		}
		scanner.close();
	}

}
