package 재귀호출;

public class 재귀테스트 {

	public static void main(String[] args) {
		// 10부터 1까지 더하는 일을 처리해라
		// 1. 반복문 사용
		int sum = 0;
		for (int i = 10; i > 0; i--) {
			sum += i;
		}
		System.out.println("반복문으로 처리한 결과: " + sum);
		
		// 2. 재귀메서드 사용
		/*
		 * f(10) == 10 + f(9);
		 * f(9) == 9 + f(8);
		 * ...
		 * 
		 * f(n) == n + f(n-1);, n > 0이고 n이 1이면 1을 리턴하고 끝냄
		 */
		System.out.println("재귀호출로 처리한 결과: " + add(10));
		
	}
	
	public static int add(int n) {
		if (n <= 0) return 0;
		if (n == 1) return 1;
		return n + add(n-1);
	}
}
