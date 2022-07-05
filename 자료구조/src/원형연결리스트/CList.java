package 원형연결리스트;

import java.util.NoSuchElementException;

public class CList<E> {
	private Node<E> last;
	private int size;

	public CList() {
		last = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void insert(E newItem) {
		Node<E> newNode = new Node<E>(newItem, null);
		if (last == null) { // 리스트가 empty 일 때
			newNode.setNext(newNode);
			last = newNode;
		} else {
			newNode.setNext(last.getNext()); // newNode의 다음 노드가 last가 가리키는 노드의 다음노드가 되도록
			last.setNext(newNode);
		}
		size++;
	}

	public Node<E> delete() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		Node<E> x = last.getNext();

		if (x == last)
			last = null;
		else {
			last.setNext(x.getNext());
			x.setNext(null);
		}
		size--;
		return x;
	}

	public void print() {
		if (size > 0) {
			int i = 0;
			for (Node<E> p = last.getNext(); i < size; p = p.getNext(), i++) {
				System.out.print(p.getItem() + "\t");
			}
		} else {
			System.out.println("Empty");
		}
		System.out.println();
	}

}
