
public class 오버로딩테스트 {

	public static void main(String[] args) {
		// 오버로딩된 메서드 add에 대해 다음을 실행해보자
		int a = 10;
		long b = 20L;
		
		add_one(b);
		// 정수를 넘김
		add_one(a);
		
		// 정의된 add와 일치하는 인수 타입으로 호출
		System.out.println(add(a, b));
		System.out.println(add(b, a));

		// 정의된 add와 일치하지 않은 인수 타입으로 호출
		// 에러 메세지가 다름
		// 오버로딩을 한 의도를 해치지 않기 위해 자동 형병환이 안된다.
//		System.out.println(add(a, a));
//		System.out.println(add(b, b));
	}

	public static long add_one (long a) {
		return a + 1;
	}
	
	public static long add(int a, long b) {
		System.out.println("long add(int a, long b)");
		return a + b;
	}

	public static long add(long a, int b) {
		System.out.println("long add(long a, int b)");
		return a + b;
	}

}
