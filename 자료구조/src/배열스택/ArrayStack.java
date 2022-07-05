package 배열스택;

public class ArrayStack<E> {
	private E s[];
	private int top;
	
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
}
