package 추상클래스;

public class 스타크래프트 {

	public static void main(String[] args) {
		// 추상클래스는 객체를 만들 수 있나?
		// ==> 불가능
		// 유닛 유 = new 유닛();

		마린 m = new 마린();
		파이어뱃 fb = new 파이어뱃();

		m.공격();
		fb.공격();

		/*
		 * 여러 마리의 마린과 파이어뱃이 합동공격을 하도록 합동공격()이라는 메소드를 만들어봐라
		 */
		유닛[] u = { new 마린(), new 마린(), new 파이어뱃(), new 마린(), new 파이어뱃(), new 마린() };
		합동공격(u);
		
		사이언스배슬 sv = new 사이언스배슬();
		sv.날기();
		sv.공격();
		sv.잠수();
		
	}

	/*
	 * 매개변수로 무엇을 넘겨주나? 유닛의 종류(하위클래스), 개수가 상황에 따라 달라질 수 있음을 고려
	 */
	public static void 합동공격(유닛[] u) { // 업캐스팅
		for (int i = 0; i < u.length; i++) {
			u[i].공격(); // 동적 바인딩
		}
	}

}
