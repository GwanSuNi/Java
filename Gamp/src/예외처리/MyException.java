package 예외처리;

public class MyException extends Exception {
	Something something = null;
	
	public MyException(Something something) {
		this.something = something;
	}
	
	public MyException(String name, int number) {
		this.something = new Something(name, number);
	}
	
}
