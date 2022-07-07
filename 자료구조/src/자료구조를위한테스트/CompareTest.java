package 자료구조를위한테스트;

public class CompareTest {
	public static void main(String[] args) {
		// 학생 두 명을 만들어 보자
		Student s1 = new Student("김경민", "19831001", "컴퓨터소프트웨어");
		Student s2 = new Student("김경민", new String("19831001"), "컴퓨터소프트웨어");

		// 문제1 : 두 학생이 같은 지 확인하려면 ?
		// 학번가지고 판단해야함 ==> 학번은 문자열, 문자열의 같은 지 여부는?

		// case 1 : == 연산자 사용
		if (s1.getSno() == s2.getSno()) {
			System.out.println("같은 학생");
		} else {
			System.out.println("다른 학생");
		}
		// 문제2 : s2의 학번을 생성자에 넘길 때 new String("19831001")으로 넘겼다면?
		// "19831001"는 리터럴이고 여러 변수가 동일 값의 리터럴을 가지면 동일 메모리 주소의 값을 참조하게 됨 ==> 문제의 원인
		// case 2 : equals() 사용
		if (s1.getSno().equals(s2.getSno())) {
			System.out.println("같은 학생");
		} else {
			System.out.println("다른 학생");
		}

		// 문제3 : s1과 s2에 대해 학번을 기준으로 정렬하려면?
		// 문자열에 대한 대소비교가 가능해야함
		if (compare(s1.getSno(), s2.getSno()) == 0) {
			System.out.println("compare 같은 학생");
		} else {
			System.out.println("compare 다른 학생");
		}
		// Student2 클래스로부터 2개의 인스턴스를 생성
		Student2 s2_1 = new Student2("김경민", "19831001", "컴퓨터소프트웨어");
		Student2 s2_2 = new Student2("홍길동", new String("19831002"), "컴퓨터소프트웨어");

		// Student2의 두 학생을 학번순으로 정하기 위해 Student2의 compareTo로 대소비교 해보기
		if (s2_1.compareTo(s2_2) > 0) {
			System.out.printf("%s 학생이 %s 학생보다 학번이 나중입니다.", s2_1.getName(), s2_2.getName());
		} else if (s2_1.compareTo(s2_2) < 0) {
			System.out.printf("%s 학생이 %s 학생보다 학번이 먼저입니다.", s2_1.getName(), s2_2.getName());
		} else {
			System.out.printf("%s 학생이 %s 학생과 학번이 같습니다.", s2_1.getName(), s2_2.getName());
		}

	}

	// s1과 s2의 내용이 같으면 0
	// s1의 길이가 s2보다 크면 1 또는 양수
	// s1의 길이가 s2보다 작으면 -1 또는 음수
	public static int compare(String s1, String s2) {
		// s1과 s2의 주소가 같다면?
		if (s1 == s2)
			return 0;
		// s1과 s2가 같은 길이라면? --> 같은 문자열 일 가능성 있음
		if (s1.length() == s2.length()) {
			// 각 위치가 동일 문자인지 검사
			for (int i = 0; i < s1.length(); i++) {
				if (s1.charAt(i) != s2.charAt(i)) // 달라진 시점에서 크기 비교
					return s1.charAt(i) - s2.charAt(i);
			}
			return 0;
		} else {
			// 아니면? --> 다른 문자열, 뭘 return해야하나?
			return s1.length() - s2.length();
		}

	}
}
