package 다차원배열활용;

import Practice.Ansi;

public class BingGo implements Ansi {
	private int board[][];
	private boolean checkBoard[][];

	BingGo(int N) {
		board = new int[N][N];
		checkBoard = new boolean[N][N];

		initBoard();
	}

	public void initBoard() {
		// board 에 숫자 지정
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = i * board.length + j + 1;
			}
		}
		// 중복 없애기 위해 내부에서 교환
		int x = 0, y = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				x = (int) (Math.random() * board.length);
				y = (int) (Math.random() * board.length);

				int temp = board[i][j];
				board[i][j] = board[x][y];
				board[x][y] = temp;
			}
		}
		// 테스트용 임시로 값 보여주기
//		for (int i = 0; i < board.length; i++) {
//			for (int j = 0; j < board.length; j++) {
//				System.out.printf("%3d", board[i][j]);
//			}
//			System.out.println();
//		}
		
		// checkBoard false로 초기화
		for (int i = 0; i < checkBoard.length; i++) {
			for (int j = 0; j < checkBoard[0].length; j++) {
				checkBoard[i][j] = false;
			}
		}
	}

	public boolean check(int n) {
		// n이 보드상에 어디 있는지 찾아서 check board에 마킹된 숫자인지 아닌지 판별해 이미 마킹 돼있으면 false 반환
		// 아니면 checkBoard 해당 위치를 true로 만든뒤 true 반환
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == n && checkBoard[i][j] == false) {
					checkBoard[i][j] = true;
					return true;
				}
			} // end for j
		} // end for i
		return false;
	}

	public boolean isBingGo() {
		// checkBoard에서 N*2+2 방향에서 빙고인지 확인 후 리턴
		byte vertical[] = new byte[board.length];
		byte horizontal[] = new byte[board.length];
		byte diagonal[] = new byte[2];

		for (int i = 0; i < checkBoard.length; i++) {
			for (int j = 0; j < checkBoard[0].length; j++) {
				// // diagonal
				// if (((i == j) || (i + j == checkBoard.length)) && checkBoard[i][j] == true) {
				// 하나씩 방문하면서 배열에 카운트 증가
				if (checkBoard[i][j] == true) {
					vertical[i]++;
					horizontal[j]++;
					if (i == j) {
						diagonal[0]++;
					}
					if (i + j == board.length - 1) {
						diagonal[1]++;
					}
				}
			} // end for j
		} // end for i
			// 행렬 검사
		for (int i = 0; i < board.length; i++) {
			if (horizontal[i] == board.length || vertical[i] == board.length) {
				return true;
			}
		}
		// 대각선 검사
		for (int i = 0; i < 2; i++) {
			if (diagonal[i] == board.length) {
				return true;
			}
		}
		return false;
	}

	// 테스트용 임시로 보여주기
	public void showStatus() {
		for (int i = 0; i < checkBoard.length; i++) {
			for (int j = 0; j < checkBoard[0].length; j++) {
				if (checkBoard[i][j]) {
					System.out.print(FONT_CYAN);
					System.out.printf("%6s ", checkBoard[i][j]);
					System.out.print(RESET);
				} else {
					System.out.print(FONT_BLACK);
					System.out.printf("%6s ", checkBoard[i][j]);
					System.out.print(RESET);
				}
			}
			System.out.println();
		}
	}
}