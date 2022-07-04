package 단순연결리스트;

public class TestSList {

	public static void main(String[] args) {
		// 문자열을 저장하는 단순연결리스트 생성
		SList<String> slist = new SList<String>();
		
		
		slist.insertFront(new String("Hello World!"));
		slist.insertFront(new String("Hello"));
		slist.insertFront(new String("World!"));
		
		slist.insertLast(new String("New"));

		
		slist.print();

		
		
	}

}
