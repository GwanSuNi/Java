package 다차원배열활용;

public class BingGo {
	private int board[][];
	private boolean checkBoard[][];

	BingGo(int N) {
		board = new int[N][N];
		checkBoard = new boolean[N][N];
		
		initBoard();
	}

	public void initBoard() {
		// board 에 숫자 랜덤 지정

		// checkBoard false로 초기화
	}
	
	public boolean check(int n) {
		// n이 보드상에 어디 있는지 찾아서 check board에 마킹된 숫자인지 아닌지 판별해 이미 마킹 돼있으면 false 반환
		// 아니면 checkBoard 해당 위치를 true로 만든뒤 true 반환
	}
	
	public boolean isBingGo() {
		// checkBoard에서 N*2+2 방향에서 빙고인지 확인 후 리턴
	}
}
