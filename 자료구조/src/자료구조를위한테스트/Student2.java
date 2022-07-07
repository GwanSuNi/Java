package 자료구조를위한테스트;
/*
 *  Student2 클래스는 인스턴스끼리 대소 비교가 가능하도록 설계해보자
 */

public class Student2 implements Comparable<Student2> {
	private String name;
	private String sno;
	private String dept;

	public Student2(String name, String sno, String dept) {
		this.name = name;
		this.sno = sno;
		this.dept = dept;
	}

	@Override
	public int compareTo(Student2 s2) {
		// sno과 s2의 주소가 같다면?
		if (sno == s2.getSno())
			return 0;
		// sno과 s2가 같은 길이라면? --> 같은 문자열 일 가능성 있음
		if (sno.length() == s2.getSno().length()) {
			// 각 위치가 동일 문자인지 검사
			for (int i = 0; i < sno.length(); i++) {
				if (sno.charAt(i) != s2.getSno().charAt(i)) // 달라진 시점에서 크기 비교
					return sno.charAt(i) - s2.getSno().charAt(i);
			}
			return 0;
		} else {
			// 아니면? --> 다른 문자열, 뭘 return해야하나?
			return sno.length() - s2.getSno().length();
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

}
