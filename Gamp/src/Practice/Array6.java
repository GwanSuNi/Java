package practice;

public class Array6 implements Ansi {

	public static void main(String[] args) {
		char[] a = { 'a', 'd' };
		char[] b = { 'c', 'd' };
		boolean judge = false;

		if (a.length == b.length) {
			for (int i = 0; i < a.length; i++) {
				if (a[i] == b[i])
					judge = true;
				else {
					judge = false;
					break;
				}
			}
		} else {
			judge = false;
		}

		System.out.print(FONT_RED + judge + RESET );

	}

}
