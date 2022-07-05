package 이중연결리스트;

import java.util.NoSuchElementException;

public class TestDList {

	public static void main(String[] args) {
		// 문자열을 데이터 항목으로 가지는 이중 연결리스트 dlist를 하나 만들어보자
		DList<String> dlist = new DList<String>();

		// 빈 리스트인지 확인하는 코드
		System.out.println((dlist.isEmpty()) ? "빈 리스트" : "비지 않음");

		// 배와 앵두를 리스트에 추가해보기
		dlist.insertBefore(dlist.getTail(), "배");
		dlist.insertBefore(dlist.getTail(), "앵두");
		dlist.print();

		// 배 찾기
		DNode<String> p = dlist.find("배");
		// 배 다음에 사과 넣기
		dlist.insertAfter(p, "사과");
		dlist.print();

		// 배 지우기
		try {
			dlist.delete(dlist.find("do")); // dlist.delete(p);
			dlist.print();
		} catch (NoSuchElementException e) { // catch 부분은 여러개 나올 수 있는데, 작은 단위부터 먼저 검사 젤 마지막은 exception에서 파악 가능
			System.out.println(e.toString());
		} finally {
			// 무조건 실행
		}

	}

}
