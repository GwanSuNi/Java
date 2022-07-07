package 배열리스트;

import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")
public class ArrList<E> {
	private E a[]; // 리스트의 항목들을 저장할 배열
	private int size; // 리스트의 항목 수

	public ArrList() {
		a = (E[]) new Object[1]; // 최초로 1개의 원소를 가진 배열 생성
		size = 0; // 항목 수를 0으로 초기화
	}

	public E peek(int k) { // k번째 항목 리턴, 단순히 읽기만
		if (isEmpty()) {
			throw new NoSuchElementException(); // underflow 일 경우에 프로그램 정지
		}
		if (k < size) { // 유효한 범위인 확인
			return a[k];
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	public boolean isEmpty() {
		return size == 0; // 리스트가 empty면 true 리턴
	}

	public void insertLast(E newItem) { // 가장 뒤에 새 항목 삽입
		if (size == a.length) {
			resize(2 * a.length);
		}
		a[size++] = newItem;
	}

	public void insertFirst(E newItem) { // 맨 앞[0]에 새 항목 삽입
		// [0]이 들어가고 나머지 이동할 공간 있나 확인
		if (size == a.length) {
			resize(2 * a.length);
		} else {
			// 가능하면 [1]부터 [size-1]까지의 데이터를 +1 인덱스로 이동 후 [0]에 새 데이터 삽입
			// 가능하지 않으면 배열 크기 조정 후 위의 과정 실행
			for (int i = size - 1; i >= 0; i--) {
				a[i + 1] = a[i];
			}
			a[0] = newItem;
			size++;
		}
	}

	public void insert(E newItem, int k) {
		if (size == a.length) {
			resize(2 * a.length);
		}
		for (int i = size - 1; i >= k; i--) {
			a[i + 1] = a[i];
		}
		a[k] = newItem;
		size++;
	}

	public E delete(int k) {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		if (k <= size) {
			E item = a[k];
			for (int i = k; i < size; i++) {
				a[i] = a[i + 1];
			}
			size--;
			if (size == 0 && size == a.length / 4) {
				resize(a.length / 2);
			}
			return item;
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	private void resize(int newSize) { // TODO 사이즈 감소 체크
		if (newSize > size) {
			Object[] t = new Object[newSize];

			for (int i = 0; i < size; i++) {
				t[i] = a[i];
			}
			a = (E[]) t;
		} 
	}

	public void print() {
		if (isEmpty()) {
			System.out.println("배열이 비어있음");
		} else {
			for (int i = 0; i < size; i++) {
				System.out.print(a[i] + "\t");
			}
			System.out.println();
		}
	}

}
