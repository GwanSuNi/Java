package practice;

public class Matrix {

	public static void main(String[] args) {
		int m1[][] = { { 1, 2, 3 }, { 4, 5, 6 } };

		int m2[][] = { { 1, 2 }, { 3, 4 }, { 5, 6 } };

		final int ROW = m1.length; // m1 의 행 길이
		final int COL = m2[0].length; // m2의 열 길이
		final int M2_ROW = m2.length; // m2의 행 길이

		int m3[][] = new int[ROW][COL];

		// 행렬곱 m1 * m2 의 결과를 m3에 저장
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				for (int k = 0; k < M2_ROW; k++) {
					m3[i][j] += m1[i][k] * m2[k][j];
				}
			}
		}

		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				System.out.printf("%3d ", m3[i][j]);
			}
			System.out.println();
		}
	}

}
