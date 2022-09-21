package toString오버라이딩테스트;

public class Student /* extends Object 가 생략된 상태 */{
	String sno;
	String dept;
	String name;
	public Student(String sno, String dept, String name) {
		super();
		this.sno = sno;
		this.dept = dept;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Student [sno=" + sno + ", dept=" + dept + ", name=" + name + "]";
	}
	
	@Override
	public boolean equals(Object o) {
		Student s = (Student) o;
		return this.sno.equals(s.sno);
	}
	
	
	public static void main(String[] args) {
		Student s1 = new Student("22", "컴소", "김경민");
		Student s2 = new Student("22", "컴소", "김경민");
		
		System.out.println(s1);
		System.out.println(s2);
		
		// s1과 s2가 같은 학생인지 검사
		// 위에 override가 있으면 내용물 검사
		// 없으면 주소를 검사
		System.out.println(s1.equals(s2));
		
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
		// 혹시, 일반 문자열(String) 클래스는 ?
		String str1 = "햄버거";
		String str2 = "햄버거";
		
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		System.out.println(str1.toString());
		System.out.println(str2.toString());
		
	}
	
}
