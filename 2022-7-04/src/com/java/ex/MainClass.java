package com.java.ex;

import java.util.LinkedList;

public class MainClass {

	public static void main(String[] args) {
		LinkedList<String> lnList = new LinkedList<String>();

		// 배열 리스트에 문자열 4개 추가
		lnList.add("문자열1");
		lnList.add("문자열2");
		lnList.add("문자열3");
		lnList.add("문자열4");

		// 일단 모두 출력 toString() 생략 가능
		System.out.println(lnList.toString());
		
		// add(내용);
		lnList.add("문자열5");
		System.out.println(lnList.toString());
		
		// add(인덱스, 내용);
		lnList.add(2, "추가 문자열1");
		System.out.println(lnList.toString());
		
		lnList.add(2, "추가 문자열2");
		System.out.println(lnList.toString());

		// size(); 리스트의 크기 반환
		int size = lnList.size();
		System.out.println("LinkedList 크기: " + size);

		// remove(인덱스); 해당 인덱스의 값 삭제
		lnList.remove(2);
		System.out.println(lnList.toString());

		// clear(); 내용 초기화
		lnList.clear();
		System.out.println(lnList.toString());

		// 참조 제거
		lnList = null;
		System.out.println(lnList);
		// System.out.println(lnList.size());
	}

}
