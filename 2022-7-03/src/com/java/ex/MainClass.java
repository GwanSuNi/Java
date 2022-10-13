package com.java.ex;

import java.util.ArrayList;

public class MainClass {

	public static void main(String[] args) {
		ArrayList<String> arrList = new ArrayList<String>();
		
		// 배열 리스트에 문자열 4개 추가
		arrList.add("문자열1");
		arrList.add("문자열2");
		arrList.add("문자열3");
		arrList.add("문자열4");
		
		// 일단 모두 출력 toString() 생략 가능
		System.out.println(arrList.toString());
		
		// get(인덱스); 인덱스 3의 값 출력
		String index = arrList.get(3);
		System.out.println("index 3에 해당하는 값: " + index);
		
		// set(인덱스, 내용);
		arrList.set(2, "문자열 바꿔치기");
		System.out.println(arrList.toString());
		
		// size(); 리스트의 크기 반환
		int size = arrList.size();
		System.out.println("ArrayList 크기: " + size);
		
		// remove(인덱스); 해당 인덱스의 값 삭제
		arrList.remove(2);
		System.out.println(arrList.toString());
		
		// clear(); 내용 초기화
		arrList.clear();
		System.out.println(arrList.toString());
		
		// 참조 제거
		arrList = null;
		System.out.println(arrList);
		// System.out.println(arrList.size());
		
	}

}
