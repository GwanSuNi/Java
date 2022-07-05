package 이중연결리스트;

import java.util.NoSuchElementException;

public class DList<E> {
	private DNode<E> head, tail;
	private int size;

	public DList() {
		head = new DNode<E>(null, null, null);
		tail = new DNode<E>(null, head, null); // tail의 이전 노드를 head로 만든다

		head.setNext(tail); // head의 다음 노드를tail로 만든
		size = 0;
	}

	public DNode<E> getHead() {
		return head;
	}

	public void setHead(DNode<E> head) {
		this.head = head;
	}

	public DNode<E> getTail() {
		return tail;
	}

	public void setTail(DNode<E> tail) {
		this.tail = tail;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public boolean isEmpty() {
		return tail.getPrevious() == head;
		// return head.getNext() == tail; 과 같음
		// return size == 0;
	}

	public void insertBefore(DNode<E> p, E newItem) {
//		DNode<E> t = p.getPrevious();
//		DNode<E> newNode = new DNode<E>(newItem, t, p);
//		p.setPrevious(newNode);
//		t.setNext(newNode);
//		size++;

		// 임시 노드 t 사용하지 않고 하는 방법
		DNode<E> newNode = new DNode<E>(newItem, p.getPrevious(), p);

		p.setPrevious(newNode);
		newNode.getPrevious().setNext(newNode);
		size++;
	}

	public void insertAfter(DNode<E> p, E newItem) {
		DNode<E> newNode = new DNode<E>(newItem, p, p.getNext());

		p.setNext(newNode);
		p.getNext().setPrevious(newNode);
		size++;
	}

	public DNode<E> find(E item) {
		DNode<E> p = head;
		while (p != null) {
			if (p.getItem() == item) {
				break;
			}
			p = p.getNext();
		}
		return (DNode<E>) p;
	}

	public void delete(DNode<E> x) {
		if (x == null)
			throw new NoSuchElementException();
		DNode<E> f = x.getPrevious();
		DNode<E> r = x.getNext();
		
		f.setNext(r);
		r.setPrevious(f);
		size--;
	}

	public void print() {
		if (isEmpty()) {
			System.out.println("리스트 비어있음");
		} else {
			for (DNode<E> p = head.getNext(); p != tail; p = p.getNext()) {
				System.out.print(p.getItem() + "\t");
			}
			System.out.println();
		}
	}
}
