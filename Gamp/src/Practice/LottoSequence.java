package practice;

public class LottoSequence {

	public static void main(String[] args) {
		int[] number = new int[6];

		for (int i = 0; i < number.length; i++) {
			number[i] = (int) (Math.random() * 6 + 1);
			for (int j = i - 1; j >= 0; j--) { // 전 인덱스의 값을 비교해서 같으면 i 인덱스의 값을 다시 생성
				if(number[i] == number[j]) {
					i--;
					break;
				}
			}
		}
		
		for(var item : number) {
			System.out.printf("%3d\t", item);
		}
	}

}
