package object클래스;

public class Student {
	String sno, name, dept;

	public Student(String sno, String name, String dept) {
		super();
		this.sno = sno;
		this.name = name;
		this.dept = dept;
	}
	
	// Object 타입으로 전달해도 오버라이드라고 할 수 있다
	public boolean equals(Student s) {
		return this.sno.equals(s.sno);
	}
	
//	@Override
//	public boolean equals(Object s) {
//		return this.sno.equals(((Student)s).sno);
//	}
	
	@Override
	public int hashCode() {
//		return sno.hashCode();
		return this.toString().hashCode();
	}
	
	@Override
	public String toString() {
		return sno+name+dept;
	}
}
