package 배열길이변경;
/*
 * static method로 int[] changeLength(int[], length) 형식의 기능을 구현해서
 * 1. 같은 크기인 경우
 * 2. 원본보다 크게 변경하는 경우
 * 3. 원본보다 작게 변경하는 경우
 * 각 경우를 처리하도록 할 것
 * 
 * 단, 배열의 크기(length)와 상관없이 실제 유효한 값이 size라는 변수로 관리된다.
 */

public class ArrayLengthCange_3 extends MyArray {

	ArrayLengthCange_3(int length) {
		super(length);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int a[] = { 10, 20, 30, 0, 0 };
		int a_size = 3;

		// case 3 - 유효한 데이터 크기보다 더 작게 하려는 경우 
		a = changeLength(a, a_size, 2);
		showArrayInfo(a);
		
		// case 1
		a = changeLength(a, a_size, a.length);
		showArrayInfo(a);

		// case 2
		a = changeLength(a, a_size, a.length + 3);
		showArrayInfo(a);

		// case 3 - 유효한 데이터 크기와 같거나 크게 하는 경우  
		a = changeLength(a, a_size, 4);
		showArrayInfo(a);

		MyArray myarray1 = new MyArray(2);
		myarray1.add(100);
		myarray1.showData();
		
		myarray1.add(20);
		myarray1.showData();
		
		myarray1.delete();
		myarray1.showData();
		
		myarray1.delete();
		myarray1.showData();
	}

	public static int[] changeLength(int[] a, int a_size, int length) {
		if (a.length < length) {
			int b[] = new int[length];
			for (int i = 0; i < a_size; i++) {
				b[i] = a[i];
			}
			return b;
		} else if (a.length > length) {
			// a의 배열 크기와 유효데이터 크기 중 유효데이터 크기를 비교
			if (a_size <= length) {
				// 새로운 배열 만들고 데이터 복사
				int b[] = new int[length];
				for (int i = 0; i < a_size; i++) {
					b[i] = a[i];
				}
				return b;
			} else {
				System.out.println("데이터 손실 가능성 있음");
				return a;
			}

		}
		return a;
	}

	static void showArrayInfo(int[] a) {
		System.out.printf("배열길이 : %d, ", a.length);
		for (int i = 0; i < a.length; i++) {
			System.out.printf("%d\t", a[i]);
		}
		System.out.println();
	}

}
