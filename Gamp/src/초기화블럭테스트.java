
public class 초기화블럭테스트 {
	
	int a;
	static int b;
	
	// 클래스 초기화 블럭
	static {
		// b는 초기화 가능, a는 불가
		System.out.println("클래스 초기화 블럭 실행");
	}
	
	// 인스턴스 초기화 블럭
	{
		// a, b 초기화 가능
		System.out.println("인스턴스 초기화 블럭 실행");
	}

	초기화블럭테스트() {
		System.out.println("생성자 실행");
	}
	public static void main(String[] args) {
		// 클래스 초기화 블럭은 인스턴스 생성을 안해도 메모리 로딩될 때 실행 된다
		// 초기화블럭테스트 app = new 초기화블럭테스트();
	}

}
