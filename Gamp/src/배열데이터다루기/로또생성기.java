package 배열데이터다루기;

import practice.Ansi;

/*
 * 랜덤하게 생성한 번호에 대한 중복 검증을 어떻게 하면 좋을까?
 * - 뽑힌 번호의 상태를 어떻게 유지할 지 --> 자료구조의 형태
 * - 6개의 중복 없는 숫자 저장하는 방법
 */
public class 로또생성기 implements Ansi {
	static boolean ball[] = new boolean[45];
	static int ballcount[] = new int[45];
	static int Lotto[] = new int[6];
	static int pos = 0;

	public static void main(String[] args) {
		// ball의 값 초기화 확인

		int N = 100;
		while (N > 0) {
			for (int i = 0; i < ball.length; i++) {
				ball[i] = false;
			}
			pos = 0;
			while (pos < Lotto.length) {
				// 랜덤 넘버 뽑기
				int n = (int) (Math.random() * ball.length);

				// 중복 확인
				if (ball[n])
					continue; // 중복이면 다시 뽑기 위치로

				// 중복이아니면 ball을 true로 세팅하고
				ball[n] = true;

				// 뽑은 번호를 lotto의 pos 위치에 기록 후 pos를 1 증가
				Lotto[pos] = n + 1;
				pos++;

			}

			for (int i = 0; i < Lotto.length; i++) {
				System.out.printf("%3d", Lotto[i]);
				ballcount[Lotto[i] - 1]++; // ballcount 의 로또 번호 - 1 의 인덱스의 값을 증가
			}
			System.out.println();
			N--;
			// TODO 가장 많이 나온 숫자 구하기 Array.sort() 활용 X 6개 띄어내기
		}
		System.out.println();
		mostCount();
	} // main end

	public static void mostCount() {
		int mostLotto[] = new int[6];
		int most;
		most = 0;

		for (int i = 0; i < mostLotto.length; i++) {
			for (int j = 0; j < ballcount.length; j++) {
				if (ballcount[j] > most) { // 큰 값이 나오면 그 인덱스를 저장
					most = ballcount[j];
					mostLotto[i] = j + 1; // 많이 나온 로또 번호는 해당 인덱스 + 1
				}

			} // j for end
			ballcount[mostLotto[i] - 1] = 0; // ballcount의 해당 인덱스를 초기화 ; 값을 가지고 있었기 때문에 1을 빼줘야 인덱스
			most = 0;
		} // i for end

		for (int i = 0; i < ballcount.length; i++) { // ballcount print by index
			if (i % 5 == 0) { // 확인 시인성 향상용
				System.out.printf(FONT_CYAN + "%3d" + RESET, ballcount[i]);
			} else {
				System.out.printf("%3d", ballcount[i]);
			}
		}

		System.out.println();
		
		System.out.print("가장 자주 뽑인 로또 6개> ");
		for (int i = 0; i < mostLotto.length; i++) {
			System.out.printf("%3d ", mostLotto[i]); // 젤 많이 나온 로또번호
		}
	}

}
