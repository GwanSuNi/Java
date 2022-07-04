package 배열리스트;

public class TestArrList {

	@SuppressWarnings("removal")
	public static void main(String[] args) {
		// 정수값(Integer)을 저장하는 ArrList를 만들어라.
		
		ArrList<Integer> alist = new ArrList<Integer>();
		
		System.out.println("배열리스트가 " + ((alist.isEmpty()) ? "비었음" : "비지 않았음"));
		// 정수값 10, 20, 30을 차례로 insertLast()로
		alist.insertLast(new Integer(10));
		alist.insertLast(20); // 자동 Boxing
		alist.insertLast(new Integer(30));
		alist.print();
		
		// 정수값 40, 50을 차례로 insertFirst()로
		alist.insertFirst(50);
		alist.print();
		
		// 정수값 70을 3번째 자리로 insert()
		alist.insert(70, 3);
		alist.print();
	}

}
