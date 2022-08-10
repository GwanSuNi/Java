
public class 가변인자테스트 {

	public static void main(String[] args) {
		System.out.println(sum(1,2,3,4,5));
		System.out.println(sum(1,2,3,4,5,6,7,8,9,10));
	}
	
	static int sum(int... arg) {
		int sum = 0;
		for(int i = 0; i < arg.length; i++) {
			sum += arg[i];
		}
		return sum;
	}
	// 정수를 입력받아 합을 구하는 메서드를 작성하라
	// 단, 정수의 개수는 매번 다르다
}
