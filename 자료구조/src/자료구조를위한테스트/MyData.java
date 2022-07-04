package 자료구조를위한테스트;
/*
 * 제네릭 클래스 : 하나의 클래스로 여러 유형(데이터 타입)의 멤버를 수용할 수 있도록 하는 것
 * 예) MyData의 item에는 어쩔 때는 정수값 배열, 어떨 때는 문자열 배열로 하고 싶다면?
 * ==> Generic Class로 정의하면 됨!
 */

public class MyData<E> {
	E[] item;

	MyData(E[] item) {
		this.item = item;
	}

	public void printData() {
		for (int i = 0; i < item.length; i++) {
			System.out.print(item[i] + " ");
		}
		System.out.println();
	}
}
