package exception테스트;

public class MyException extends Exception {
	// 에러 코드 값을 저장하기 위한 필드 추가
	private final int ERR_CODE; // 생성자를 통해 초기화
	
	MyException(String msg, int errCode) {
		super(msg);
		ERR_CODE = errCode;
	}
	
	MyException(String msg) {
		this(msg, 100);
	}
	
	public int getErrCode() {
		return ERR_CODE;
	}
}
