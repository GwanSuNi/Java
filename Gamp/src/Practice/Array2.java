package Practice;

public class Array2 {

	public static void main(String[] args) {
		int a[][] = { { 'A', 'B', 'C' }, { 'D', 'E', 'F' } };
		
		System.out.println ("행 길이: " + a.length + "\t열 길이: " + a[0].length);
		
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[i].length; j++) {
				System.out.printf("a[%d][%d] = %c \t", i , j, a[i][j]);
			}
			System.out.println();
		}
	}

}
