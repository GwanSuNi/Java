package 캐스팅;
/*
 * 동물(Animal) 클래스의 하위에 개(Dog)와 고양이(Cat)가 있다고 할 때,
 * 개는 멍멍하고 짖고, 고양이는 야옹하고 운다.
 * 
 * 질문: 각 동물들이 소리내는 것을 하위(상세) 클래스에서 각각 따로 구현하는 것이 좋을까?
 * 답:	동물 클래스에 각 동물의 소리를 내는 메소드를 두고 
 * 		하위 클래스에서 오버라이딩으로 개별적인 소리를 내도록 함
 * 
 * 결국 다형성을 활용해서 클래스를 설계하자
 */
public class Animal { // 원래는 추상클래스로 만들어야함
	String name;
	
	public Animal(String name) {
		this.name = name;
	}
	
	public void 소리내기() {
		System.out.println("동물이 소리를 냅니다.");
	}
}
