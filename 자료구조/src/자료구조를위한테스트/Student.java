package 자료구조를위한테스트;

public class Student {
	private String name;
	private String sno;
	private String dept;

	public Student(String name, String sno, String dept) {
		this.name = name;
		this.sno = sno;
		this.dept = dept;
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
