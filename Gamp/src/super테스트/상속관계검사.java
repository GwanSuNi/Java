package super테스트;

public class 상속관계검사 {

	public static void main(String[] args) {
		ClassA oa = new ClassC();
		ClassB ob = new ClassC();
		ClassC oc = new ClassC();
		
		// 각 참조변수로 멤버 a를 찍으면 어떤 값이 찍힐까?
		// 각 클래스에 a가 따로 선언되어 있으므로 해당 클래스 타입의 멤버를 출력
		System.out.println(oa.a);
		System.out.println(ob.a);
		System.out.println(oc.a);
		
		// 만약 ClassB가 멤버 a를 선언하지 않았다면?
		// System.out.println(ob.a); 는 ClassA의 멤버 a를 출력
		
		// oc의 부모가 가진 a의 값 출력하려면?
		System.out.println(oc.getSuperA());
		
		// oc의 할아버지가 가진 a의 값 출력하려면?
		// ClassB 에 메소드 추가해서 호출
	}

}
