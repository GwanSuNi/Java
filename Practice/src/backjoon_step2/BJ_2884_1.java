package backjoon_step2;

import java.util.Scanner;

class BJ_2884_1 {
	public static void main(String[] args) {
		int hour, min;
		Scanner scanner = new Scanner(System.in);
		hour = scanner.nextInt();
		min = scanner.nextInt();
		
		if (min < 45) { // 분이 45보다 작을 때
			if (hour == 0) { 
				hour = 23; // 24시 순환
			} else {
				--hour; // 바로 한 자리 내려주면 됨
			}
			min = 60 - (45 - min); // 60분 순환
		} else { // 분이 45보다 클 때
			min -= 45; // 분만 빼주면 됨
		}
		System.out.println(hour + " " + min);
		scanner.close();
	}
}
