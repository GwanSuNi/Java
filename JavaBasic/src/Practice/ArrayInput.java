package Practice;

import java.util.Scanner;

public class ArrayInput { // p166 #8

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int leng = scan.nextInt();
		if (leng < 100) {
			int a[] = new int[leng];
			for (int i = 0; i < a.length; i++) {
				a[i] = (int) (Math.random() * 100 + 1);
				for (int j = i - 1; j >= 0; j--) {
					if (a[i] == a[j]) {
						i--;
						break;
					}
				}
			}
			for (var item : a)
				System.out.print(item + "\t");
		} else {
			System.out.println("범위 오류");
		}
		scan.close();
	}
}
