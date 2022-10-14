package 예외처리;

public class 예외_던지기 {

	public static void main(String[] args) {
		String ret = null;
		try {
			ret = method1();
		} catch (MyException e) {
			System.out.println("메인 처리반");
			ret = e.getMessage();
			System.out.println("name: " + e.something.name);
		} finally {
			System.out.println(ret);
		}
	}
	
	static String method1() throws MyException {
		String msg = "무사히 마침";
		try {
			msg = "무사히 마침";
			throw new MyException("멍멍이", 10);
		} catch (Exception e) {
			System.out.println("method1() catch문");
			msg = "하다가 딱 걸림";
			throw e;
		} finally {
			System.out.println("finally");
		}
	
	}

}
