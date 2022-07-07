package 정렬;

import 자료구조를위한테스트.Student2;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class InsertionSort {
	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			for (int j = i; j > 0; j--) {
				if (isLess(a[j], a[j - 1]))
					swap(a, j, j - 1);
				else
					break;
				print(a);
			}
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

	private static void printStudent(Student2[] input) {
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i].getName() + " " + input[i].getSno() + " " + (i < input.length - 1 ? ", " : "\n"));
		}
	}

	public static void main(String[] args) {
		Integer a[] = { 40, 60, 70, 50, 10, 30, 20 };
		InsertionSort.sort(a);
		System.out.println("\n정렬결과: ");
		print(a);

		Student2[] s = { new Student2("홍길동", new String("19831002"), "컴퓨터소프트웨어"),
				new Student2("김경민", new String("19831020"), "컴퓨터소프트웨어"),
				new Student2("홍길동", new String("20831040"), "컴퓨터소프트웨어") };

		InsertionSort.sort(s);
		System.out.printf("\n정렬결과: ");
		printStudent(s);

	}
}
