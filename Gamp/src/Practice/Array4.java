package practice;

public class Array4 implements Ansi{

	public static void main(String[] args) {
		int a[][] = { { 3, 5, 6, 9 }, { 2, 1, 4, 7 }, { 8, 7, 1, 6 }, { 3, 5, 4, 6 } };
		int Hsum, LDiagonalSum = 0, RDiagonalSum = 0;
		int count = 0, count2= 0;
		int Vsum[] = new int[4];

		for (int i = 0; i < a.length; i++) {
			Hsum = 0;
			for (int j = 0; j < a[i].length; j++) {
				System.out.printf("%3d ", a[i][j]);
				Hsum += a[i][j];
				Vsum[j] += a[i][j];
				// Left diagonal calculation
				if (i == j) {
					++count;
					LDiagonalSum += a[i][j];
				}
				// Right diagonal calculation
				if ( i + j == a[i].length - 1) {
					++count2;
					RDiagonalSum += a[i][j];
				}
			}
			System.out.printf(FONT_GREEN +"%3d\n\u001B[0m", Hsum);
		}

		for (int i = 0; i < a[0].length; i++)
			System.out.printf(FONT_GREEN + "%3d \u001B[0m", Vsum[i]);

		System.out.printf(FONT_PURPLE + "\nL대각선 합: %d\t 평균: %f", 
				LDiagonalSum, (double) LDiagonalSum / count);
		System.out.printf("\nR대각선 합: %d\t 평균: %f", 
				RDiagonalSum, (double) RDiagonalSum / count2);
		
	}
}
