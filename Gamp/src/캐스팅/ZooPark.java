package 캐스팅;

public class ZooPark {

	public static void main(String[] args) {
		// 동물원에 개 2마리 고양이 1마리가 사육되도록 표현해보자
		Animal zoo[] = {new Dog("멍멍이"), new Cat("야옹이"), new Dog("바둑이")};
		
		// 동물원에 사육하는 동물들이 소리를 내도록 표현해보자
		for (int i = 0; i < zoo.length; i++) {
			zoo[i].소리내기(); // 동적 바인딩
		}
		
		// 동물원에 사육하는 모든 동물들에 대해 개는 꼬리를 치도록, 고양이는 꾹꾹이를 하도록 표현해보자
		
		// 방법 1: zoo[0].꼬리치기()는 안됨.
		// 방법 2: 다운캐스팅 
		Dog d = (Dog) zoo[0];
		d.꼬리치기();
		// or
		((Dog) zoo[0]).꼬리치기();
		
		// 방법 2가 가능은 하지만 일반화 시키면 zoo[i]가 Dog인지 Cat인지 실행시간에만 알 수 있음
		// 	- 런타임 예외 발생 가능
		//  - 일일이 i 번째 인스턴스를 처리하기는 코딩이 힘들어짐
		
		
		// 방법 3: for문으로 처리하면서 instanceof로 개별적인 하위 타입으로 다운캐스팅해서 처리
		for (int i = 0; i < zoo.length; i++) {
			if (zoo[i] instanceof Dog) {
				((Dog) zoo[i]).꼬리치기();
			} else if (zoo[i] instanceof Cat) {
				((Cat) zoo[i]).꾹꾹이();
			}
		}
	}

}
