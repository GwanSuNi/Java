package 캐스팅;

public class Cat extends Animal {
	public Cat(String name) {
		super(name);
	}

	public void 소리내기() {
		System.out.println("야옹");
	}
	
	public void 꾹꾹이() {
		System.out.println("앞발로 꾹꾹~");
	}
}
