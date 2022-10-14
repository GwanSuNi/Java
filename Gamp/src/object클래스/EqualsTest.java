package object클래스;

public class EqualsTest {

	public static void main(String[] args) {
		Student s1 = new Student("20123", "김경민", "컴소");
		Student s2 = new Student("20123", "김경민", "컴소");
		
		if (s1.equals(s2)) { // 오버라이딩 안하면 주소를 검사, 내용 검사하려면 오버라이딩 해야함!
			System.out.println("같음");
		} else {
			System.out.println("다름");
		}
		
		// 각 객체의 고유 코드값; 내용이 같더라도 해시코드는 다를 수 있기 떄문에 오버라이딩 해줘야함!
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
		System.out.println(s1.toString());
		System.out.println(s2.toString());
	}

}
