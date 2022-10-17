package com.java.ex;

import java.util.HashSet;

public class MainClass {

	public static void main(String[] args) {
		HashSet<Student> hSet = new HashSet<Student>();
		
		hSet.add(new Student("박남일", 1));
		hSet.add(new Student("홍길동", 5));
		hSet.add(new Student("김경민", 9));
		
		System.out.println(hSet.toString());
		
		Student st = new Student("김경민", 9);
		hSet.remove(st);
		// 메모리 상 서로 다른 곳에 위치해 있기 때문에 삭제되지 않는다 -> 단순히 이렇게 쓰면 그냥 연관 없는 참조변수
		// hashCode와 equals 오버라이딩 하면 값 비교해서 삭제 가능
		System.out.println(hSet.toString());
	}

}