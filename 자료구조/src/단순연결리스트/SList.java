package 단순연결리스트;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class SList<E> {
	protected Node head; // 연결 리스트의 첫 노드를 가리킴
	private int size;

	public SList() { // 연결리스트 생성자
		head = null;
		size = 0;
	}

	// 연결리스트의 맨 앞에 데이터 추가
	public void insertFront(E newItem) {
		head = new Node(newItem, head);
		size++;
	}

	// 연결리스트의 맨 뒤에 데이터 추가
	public void insertLast(E newItem) {
		Node p = head;
		while (p.getNext() != null) {
			p = p.getNext();
		}
		// p의 다음에 item이 들어있는 노드를 연결
		p.setNext(new Node(newItem, null));
		// p.setItem(newItem); 이건 아님
	}

	public void print() {
		Node p = head;
		while (p != null) {
			System.out.println(p.getItem() + " ");
			p = p.getNext();
		}
	}

}
