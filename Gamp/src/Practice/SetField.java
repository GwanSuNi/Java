package practice;

public class SetField extends PrintStar { // 배열의 성분을 가진 클래스
	private int FirstLength;
	private int SecondLength;

	SetField() {
	}

	public int getLength() {
		return FirstLength;
	}

	public void setLength(int Length) {
		if (Length % 2 != 0)
			this.FirstLength = this.SecondLength = Length;
		else
			System.out.println("홀수만 가능합니다.");
		// 프로그램 종료 혹은 반복
	}

}
