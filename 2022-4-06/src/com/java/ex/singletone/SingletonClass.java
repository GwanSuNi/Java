package com.java.ex.singletone;

public class SingletonClass {
	// 인스턴스를 참조하는 private static 참조 변수 
	private static SingletonClass SINGLETON_CLASS_INSTANCE = new SingletonClass();
	private int i = 10;

	// 밖에서 사용할 수 없는 생성자 
	private SingletonClass() {

	}
	// 밖에서 사용 가능한 클래스타입을 반환하는 static getter() 메서드 - 클래스이름.메서드이름()
	public static SingletonClass getSingletonClass() {
		// 만약 안만들었을 때 대비 안전장치
		if (SINGLETON_CLASS_INSTANCE == null) {
			SINGLETON_CLASS_INSTANCE = new SingletonClass();
		}
		return SINGLETON_CLASS_INSTANCE;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
}
