package 문자열클래스만들기;

public class CharTest {

	public static void main(String[] args) {
		// char '\0'은 문자열 끝을 나타낼 때 주로 사용함
		char c = '\0';
		System.out.println((int)c);
		System.out.println(c);
		
		// 문자열 클래스
		String s = "abcd";
		System.out.println(s.substring(0,2));
		System.out.println(s.substring(0,4));
		System.out.println(s.substring(0, -1));
	}

}
