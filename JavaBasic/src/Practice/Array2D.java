package Practice;

public class Array2D { // p166 #10

	public static void main(String[] args) {
		int a[][] = new int[4][4];

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = (int) (Math.random() * 10 + 1);
			}
			
		}
		
		for(int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j = (int) (Math.random() * 6)) {
				a[i][j] = 0;
			}
		}

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.printf("%3d", a[i][j]);
			}
			System.out.println();
		}
	}
}
