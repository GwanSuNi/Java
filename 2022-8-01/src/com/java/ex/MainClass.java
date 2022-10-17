package com.java.ex;

import java.util.LinkedList;
import java.util.Stack;

public class MainClass {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();

		System.out.println("stack push: " + stack.push("a"));
		System.out.println("stack push: " + stack.push("b"));
		System.out.println("stack push: " + stack.push("c"));
		System.out.println("stack push: " + stack.push("d"));
		System.out.println("stack push: " + stack.push("e"));
		System.out.println("stack push: " + stack.push("f"));
		System.out.println("stack push: " + stack.push("닉퓨리"));
		System.out.println("stack push: " + stack.push("h"));
		System.out.println("========================");

		int n1 = stack.search("닉퓨리");
		if (n1 != -1) { // 해당 내용이 없을 때 -1을 리턴하기 떄문
			System.out.println("stack에서 \"닉퓨리\"의 위치: " + n1);
		} else {
			System.out.println("stack에 \"닉퓨리\"는 없다!");
		}
		System.out.println("indexOf(): " + stack.indexOf("닉퓨리"));

		System.out.println("========================");
		while (!stack.empty()) {
			String obj = stack.pop();
			// Object obj = stack.pop(); 도 사용 가능하지만 String의 메소드를 사용하려면 형변환을 다시 해줘야함!
			System.out.println("stack에서 pop: " + obj);
		}

		
		
		
		System.out.println("========================");
		System.out.println("========================");

		LinkedList<String> queue = new LinkedList<String>();
		System.out.println("queue offer: " + queue.offer("a"));
		System.out.println("queue offer: " + queue.offer("블랙위도우"));
		System.out.println("queue offer: " + queue.offer("c"));
		System.out.println("queue offer: " + queue.offer("d"));
		System.out.println("queue offer: " + queue.offer("e"));
		System.out.println("queue offer: " + queue.offer("f"));
		System.out.println("queue offer: " + queue.offer("g"));
		System.out.println("queue offer: " + queue.offer("h"));
		System.out.println("========================");

		int n2 = queue.indexOf("블랙위도우");
		if (n2 != -1) {
			System.out.println("queue에서 \"블랙위도우\"의 위치: " + n2);
		} else {
			System.out.println("queue에 \"블랙위도우\"는 없다!");
		}

		System.out.println("========================");
		while (!queue.isEmpty()) {
			Object obj = queue.poll();
			System.out.println("queue에서 poll: " + obj);
		}

	}

}
