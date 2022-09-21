package super테스트;

public class 멤버오버라이딩 {

	public static void main(String[] args) {
		SuperClass superO = new SubClass();
		SubClass subO = new SubClass();
		
		// 참조변수 선언시 지정한 클래스 타입의 범위 내에서 멤버(필드, 메서드) 접근 가능
		System.out.println(superO.a);
		System.out.println(subO.a);
	}

}
