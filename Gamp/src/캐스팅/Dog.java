package 캐스팅;

public class Dog extends Animal {
	public Dog(String name) {
		super(name);
	}

	public void 소리내기() {
		System.out.println("멍멍");
	}
	
	public void 꼬리치기() {
		System.out.println("꼬리를 살랑살랑");
	}
}
