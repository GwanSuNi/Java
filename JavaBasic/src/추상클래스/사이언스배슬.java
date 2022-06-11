package 추상클래스;

// public class 사이언스배슬 extends 유닛 implements 비행기능, 잠수기능 {
public class 사이언스배슬 extends 유닛 implements 이동기능 {
	// 유닛과 비행기능의 각 추상메소드를 구현해야함 
	@Override
	public void 날기() {
		System.out.println("슈웅 슈우웅~~~");
	}

	@Override
	public void 공격() {
		System.out.println("시야확보...");
	}

	@Override
	public void 잠수() {
		System.out.println("잠수중...");
	}

//	@Override
//	public void 도보() {
//	}
	
	/*
	 * 만약 여러 인터페이스를 묶은 인터페이스를 사용할 경우 때에 따라서 불필요한 기능이 포함되어질 수 있음
	 * 해결방법 : 
	 * 1. 아무것도 하지 않도록 바디를 구성 / 바로 위 
	 * 2. 묶은 인터페이스를 정규화 (필요한 기능만 묶음)
	 */
	
}
