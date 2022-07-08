package 정렬;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class BubbleSort {
	public void bubbleSort(int a[]) {
		int i, j, size;
		size = a.length;

		for (i = size - 1; i > 0; i--) {
			System.out.printf("\n버블 정렬 %d 단계: \n", size - i);

			for (j = 0; j < i; j++) {
				if (isLess(a[j + 1], a[j])) {
					swap(a, j, j + 1);
				}
			}
			print(a);
		}
	}

	private static boolean isLess(Comparable i, Comparable j) {
		return i.compareTo(j) < 0;
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	private static void print(int[] input) {
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + (i < input.length - 1 ? ", " : "\n"));
		}
	}
}
