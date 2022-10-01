package practice;

public class Array3 {

	public static void main(String[] args) {
		char a[];
		int count = 0;
		// "I love Java"
		String str = "I love Java";
		
		a = str.toCharArray();
		
		for(int i = 0; i < a.length; i++) {
			if(a[i] == ' ')
				++count;
			else if(a[i] == 'a')
				System.out.print(a[i] + "\t");
		}
		System.out.printf("\n공백 개수: %d", count);
	}

}
