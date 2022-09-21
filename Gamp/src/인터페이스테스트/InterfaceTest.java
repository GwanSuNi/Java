package 인터페이스테스트;

/*
 * 인터페이스를 여러개 가져다 쓸 수 있음
 * 만약 중복되는 메서드가 인터페이스 간에 존재해도 상관 없음 - 구체적으로 할 일이 없기 때문
 * 추상 메서드끼리 메서드 오버로딩 형태로 있어도 상관 없음 --> 일반 클래스에서 오버로딩 형태로 구현됨
 */
public class InterfaceTest implements InterfaceA, InterfaceB {

	@Override
	public void f() {
		System.out.println("추상 메서드 구현 완료");
	}

	@Override
	public void f(String msg) {
		System.out.println(msg);
	}

	@Override
	public void f(int i) {
		System.out.println(i);
	}

	public static void main(String[] args) {
		InterfaceTest app = new InterfaceTest();
		app.f();
		app.f("오버로딩된 메서드 출력 완료");
		app.f(1000);
	}

}
