package super테스트;

public class ClassC extends ClassB {
	int a = 300;

	public int getSuperA() {
		//return super.a;
		return super.getSuperA();
	}
	
	
}
