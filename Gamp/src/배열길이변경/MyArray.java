package 배열길이변경;

public class MyArray {
	private int size;
	private int[] data;
	
	MyArray(int length) {
		data = new int [length];
		size = 0;
	}
	// 배열에 항목 넣기
	public void add(int item) {
		// 배열의 크기를 벗어나지 않게 제어
		if (size < data.length) {
			data[size] = item;
			size++ ;
		}
	}
	
	public void delete() {
		if (size > 0) {
			size--;
			data[size] = 0;
		}
	}
	
	public void showData() {
		for(int i = 0; i < data.length; i++) {
			System.out.printf("%3d", data[i]);
		}
		System.out.println();
	}
	
}
