package Practice;

public class Lotto {

	public static void main(String[] args) {
		int[] number = new int[6];

		for (int i = 0; i < 6; i++) {
			number[i] = (int) (Math.random() * 6 + 1); // 한 번에 6개의 난수 생성 
		}
		
		// 중복 검사하는 부분
		for (int i = 0; i < number.length; i++) {
			for (int j = i + 1; j < number.length; j++) { // 자기 자신을 제외한 이후 배열들을 비교
				if (number[i] == number[j] && i != j) { // 자기 자신을 제외한 요소들의 값이 같으면 해당 인덱스 랜덤
					number[i] = (int) (Math.random() * 6 + 1);
					j = -1; // 검사 인덱스 초기화 
				}
			}
		}

		for (var item : number) {
			System.out.printf("%3d\t", item);
		}
	}
}
