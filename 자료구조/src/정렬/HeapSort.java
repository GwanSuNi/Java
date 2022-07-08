package 정렬;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class HeapSort {
	public static void sort(Comparable[] a) {
		int heapSize = a.length - 1; // a[0]는 사용안함
		for (int i = heapSize / 2; i > 0; i--) { // 힙 만들기 부모노드만 크면 되기 때문에 자식 둘을 볼 필요가 없어서 / 2 했음 
			downheap(a, i, heapSize);
		}
		while (heapSize > 1) {	// 힙 정렬
			swap(a, 1, heapSize--); // a[1]과 힙의 마지막 항목과 교환 
			downheap(a, 1, heapSize); // 위배된 힙 속성 고치기
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
}
