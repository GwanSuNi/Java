package Practice;

import java.util.Scanner;

public class Array5 {

	public static void main(String[] args) {
		boolean judge = false;
		
		System.out.print("문자열 입력 > ");
		Scanner scan = new Scanner(System.in);
		
		String input = scan.next();
		
		for(int i = 0; i < input.length()/2; i++) {
			if(input.charAt(i) == input.charAt(input.length() - 1 - i)) {
				judge = true;
			}
			else {
				System.out.print("동일하지 않음");
				judge = false;
				break;
			}
		}
		
		if (judge) {
			System.out.println("거꾸로도 똑같음");
		}
		scan.close();
	}
}
