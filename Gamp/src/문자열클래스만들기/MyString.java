package 문자열클래스만들기;

public class MyString {
	// 문자열 저장할 char형 배열과 문자열 길이에 대한 정보 필요
	char string[];

	MyString() {
		string = null;
	}

	MyString(char string[]) {
		// string의 길이만큼 this.string의 배열 크기로 생성
		this.string = new char[string.length];
		// 값 복사
		for (int i = 0; i < string.length; i++) {
			this.string[i] = string[i];
		}
	}

	public char charAt(int index) {
		// index가 string의 인덱스 범위인지 우선 검사
		// 범위 내 이면 글자 반환, 아니면 '\0' 반환
		if (index < this.string.length && index >= 0) {
			return this.string[index];
		} else {
			return '\0';
		}
	}

	public MyString subString(int from, int to) {
		MyString s = null;
		// from, to 가 인덱스 범위 내인지 검사
		// 범위 내라면 string에서 부분 문자열을 복사해 객체 s를 만든 후 반환
		if ((from >= 0 && from < string.length) && (to > 0 && to <= string.length) && from < to) {
			char c[] = new char[to - from];
			for (int i = from; i < to; i++) {
				// copy
			}
			return s;

		}
		// 범위 밖이면 s가 null인 것을 반환

		return s;
	}

	public boolean equals(MyString s) {
		// this.string 과 s의 길이가 같은 경우에만 각 인덱스 값 비교
		if (this.string.length == s.length) {

		}
		for (int i = 0; i < this.string.length; i++) {

		}
	}

	public char[] toCharArray() {
		// string의 길이만큼의 char[] 을 생성한 후 값 복사하고 반환
		char c[] = new char[string.length];
		for (int i = 0; i < string.length; i++) {
			c[i] = string[i];
		}
		return c;
	}

}
