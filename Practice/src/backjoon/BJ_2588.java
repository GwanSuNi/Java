package backjoon;

import java.util.Scanner;

class BJ_2588 {

	public static void main(String[] args) {
		String a, b;
		Scanner scanner = new Scanner(System.in);
		a = scanner.nextLine();
		b = scanner.nextLine();
		String first = b.charAt(2)+"";
		String second = b.charAt(1)+"";
		String third = b.charAt(0)+"";
		System.out.println(Integer.parseInt(a) * Integer.parseInt(first));
		System.out.println(Integer.parseInt(a) * Integer.parseInt(second));
		System.out.println(Integer.parseInt(a) * Integer.parseInt(third));
		System.out.println(Integer.parseInt(a) * Integer.parseInt(b));
		scanner.close();
	}

}
