package com.java.ex;

import java.util.HashMap;
import java.util.Iterator;

public class MainClass {
	public static void main(String[] args) {
		HashMap<Integer, String> hMap = new HashMap<Integer, String>();
		
		hMap.put(0, "문자열0");
		hMap.put(1, "문자열1");
		hMap.put(2, "문자열2");
		hMap.put(3, "문자열3");
		
		System.out.println(hMap.toString());
		
		// 해당 키 값의 아이템 가져오기
		String str = hMap.get(2);
		System.out.println(str);
		
		hMap.remove(2);
		System.out.println(hMap.toString());
		
		hMap.clear();
		System.out.println(hMap.toString() + "\n");
		
		
		hMap.put(0, "문자열0");
		hMap.put(1, "문자열1");
		hMap.put(2, "문자열2");
		hMap.put(3, "문자열3");
		System.out.println(hMap.toString());
		
		// 선형 반복 수행
		Iterator<Integer> itr = hMap.keySet().iterator();
		while (itr.hasNext()) {
			String string = hMap.get(itr.next());
			System.out.println(string);
		}
		
	}
}
