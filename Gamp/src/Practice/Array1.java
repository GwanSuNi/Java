package practice;

public class Array1 {

	public static void main(String[] args) {

		int a[] = { 1, 2, 3, 4, 5, 6 };
		int sum = 0;
		int count = 0;
		double avg;

		System.out.println("길이: " + a.length);

		for (var item : a) {
			System.out.print(item + " ");
		}
		System.out.print("\n3의 배수 : ");

		for (int i = 0; i < a.length; i++) {
			if (a[i] % 3 == 0) {
				++count;
				sum += a[i];
				System.out.print(a[i] + "\t");
			}
		}
		avg = (double) sum / count;
		System.out.printf("\n합: %d\n평균: %f\n", sum, avg);

	}

}
