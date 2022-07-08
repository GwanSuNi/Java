package 자료구조를위한테스트;

public class MaxHeapTest {

	public static void main(String[] args) {
		Comparable a[] = { 0, 60, 70, 50, 10, 30, 20 };

		int heapSize = a.length - 1; // a[0]는 사용안함
		for (int i = heapSize / 2; i > 0; i--) { // 힙 만들기 부모노드만 크면 되기 때문에 자식 둘을 볼 필요가 없어서 / 2 했음 
			System.out.println("");
			print(a);
			downheap(a, i, heapSize);
			System.out.println("");
			print(a);
		}

	}

	private static void downheap(Comparable[] a, int p, int heapSize) {
		while (2 * p >= heapSize) {
			int s = 2 * p; // s = 왼쪽 자식의 인덱
			if (s < heapSize && isLess(a[s], a[s + 1])) // 오른쪽 자식이 큰 경우
				s++;
			if (!isLess(a[p], a[s])) // 부모가 자식 승자보다 크면 힙 속성 만족
				break;
			swap(a, p, s); // 합 속성 만족 안하면 부모와 자식 승자 교환
			p = s; // 이제 자식 승자의 자리에 부모가 있게 됨
		}
	}

	private static boolean isLess(Comparable i, Comparable j) {
		return i.compareTo(j) < 0;
	}

	private static void swap(Comparable[] a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	private static void print(Comparable[] input) {
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + (i < input.length - 1 ? ", " : "\n"));
		}
	}
}