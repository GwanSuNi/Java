package 스택활용예제;

import java.util.EmptyStackException;

public class ArrayStack<E> {
	private E s[];
	private int top;

	@SuppressWarnings("unchecked")
	public ArrayStack() {
		s = (E[]) new Object[1];
		top = -1;
	}

	public int size() {
		return top + 1;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public void push(E newItem) {
		if (size() == s.length) {
			resize(2 * s.length);
		}
		s[++top] = newItem;
	}

	@SuppressWarnings("unchecked")
	private void resize(int newSize) {
		if (newSize > size()) {
			Object[] t = new Object[newSize];

			for (int i = 0; i < size(); i++) {
				t[i] = s[i];
			}
			s = (E[]) t;
		} 
	}

	public E peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return s[top];
	}

	public E pop() {
		if (isEmpty())
			throw new EmptyStackException();

		E item = s[top];
		s[top--] = null;

		if (size() > 0 && size() == s.length / 4) {
			resize(s.length / 2);
		}
		return item;
	}

	public void print() {
		if (isEmpty()) {
			System.out.println("배열이 비어있음");
		} else {
			for (int i = 0; i < size(); i++) {
				System.out.print(s[i] + "\t");
			}
			System.out.println();
		}
	}

}
