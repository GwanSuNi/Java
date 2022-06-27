package 배열데이터다루기;

import Practice.Ansi;

/*
 * 랜덤하게 생성한 번호에 대한 중복 검증을 어떻게 하면 좋을까?
 * - 뽑힌 번호의 상태를 어떻게 유지할 지 --> 자료구조의 형태
 * - 6개의 중복 없는 숫자 저장하는 방법
 */
public class 로또생성기 implements Ansi{
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
		mostCount();
	} // main end

	public static void mostCount() {
		int most[] = new int[6];
		most[0] = ballcount[0];
		
		for (int i = 1; i < ballcount.length; i++) {
			if (ballcount[i] >= most[0]) {
				most[0] = i;
			
			}
			if ((i-1) % 5 == 0) { // 확인 시인성 향상용 
				System.out.printf(FONT_CYAN + "%3d" + RESET,ballcount[i]);
			} else {
				System.out.printf("%3d", ballcount[i]);
			}
		}
		System.out.println();
		System.out.println(most[0] + 1); //젤 많이 나온 값 
	}

}
