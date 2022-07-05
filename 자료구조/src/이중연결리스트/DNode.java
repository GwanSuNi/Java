package 이중연결리스트;

public class DNode<E> {
	private E item;
	private DNode<E> previous; // 교안에는 제네릭까지 작성해서 선언하지 않았지만 이렇게 모두 포함해줘야함 (제네릭까지가 타입이라고 생각하면 편함)
	private DNode<E> next;
	
	public DNode(E newItem, DNode<E> p, DNode<E> q) {
		item = newItem;
		previous = p;
		next = q;
	}

	public E getItem() {
		return item;
	}

	public void setItem(E item) {
		this.item = item;
	}

	public DNode<E> getPrevious() {
		return previous;
	}

	public void setPrevious(DNode<E> previous) {
		this.previous = previous;
	}

	public DNode<E> getNext() {
		return next;
	}

	public void setNext(DNode<E> next) {
		this.next = next;
	}
	
	
}
