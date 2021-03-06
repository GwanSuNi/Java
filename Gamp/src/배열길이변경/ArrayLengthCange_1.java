package 배열길이변경;
/*
 * static method로 int[] changeLength(int[], length) 형식의 기능을 구현해서
 * 1. 같은 크기인 경우
 * 2. 원본보다 크게 변경하는 경우
 * 3. 원본보다 작게 변경하는 경우
 * 각 경우를 처리하도록 할 것
 */

public class ArrayLengthCange_1 {

	public static void main(String[] args) {
		int a[] = { 10, 20, 30 };

		// case 1
		a = changeLength(a, a.length);
		showArrayInfo(a);

		// case 3
		a = changeLength(a, a.length - 1);
		showArrayInfo(a);

		// case 2
		a = changeLength(a, a.length + 3);
		showArrayInfo(a);

	}

	public static int[] changeLength(int[] a, int length) {
		if (a.length < length) {
			int b[] = new int[length];
			for (int i = 0; i < a.length; i++) {
				b[i] = a[i];
			}
			return b;
		} else if (a.length > length) {

			System.out.println("데이터 손실 가능성 있음");
			return a;
		}
		return a;
	}

	static void showArrayInfo(int[] a) {
		System.out.printf("배열길이 : %d, ", a.length);
		for (int i = 0; i < a.length; i++) {
			System.out.printf("%d ", a[i]);
		}
		System.out.println();
	}

}
