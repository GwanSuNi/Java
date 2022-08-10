
public class 가변인자테스트_2 {
	// 정수를 입력받아 합을 구하는 메서드를 작성하라
		// 단, 정수의 개수는 매번 다르다
		
		public static void main(String[] args) {
			System.out.println(sum(1));
			System.out.println(sum(1,2,3,4,5));
			System.out.println(sum(1,2,3,4,5,6,7,8,9,10));
			
		}
		
		// 만약 static int sum(int... arg)로 선언된 메서드가 있는 경우
		// 이 경우는 오버로딩 할 수 없음 : 정수 a가 가변 매개변수로 취급할 지 아닐 지 호출시 알기 힘듬
		// 기존 가변인자 메소드와 구별할 수 없기 때문에 사용시 ambiguous 에러가 뜬다
		static int sum(int a, int... arg) {
			int sum = a;
		
			for(int i : arg) {
				sum += i;
			}
			return sum;
		}

}
