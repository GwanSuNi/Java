package com.java.ex.avengers;

public class Avengers implements IronMan, SpiderMan, Hulk {
	
	public Avengers() {
		System.out.println("어벤져스 소집!");
		System.out.println("Hulk");
		this.big();
		this.strong();
		System.out.println("SpiderMan");
		this.poor();
		this.web();
		System.out.println("IronMan");
		this.rich();
		this.engine();
	}

	@Override
	public void big() {
		System.out.println("헐크는 커요");
	}

	@Override
	public void strong() {
		System.out.println("헐크는 세요");
	}

	@Override
	public void poor() {
		System.out.println("스파이더맨은 가난해요");

	}

	@Override
	public void web() {
		System.out.println("스파이더맨은 거미줄을 사용해요");
	}

	@Override
	public void rich() {
		System.out.println("아이언맨은 부자에요");
	}

	@Override
	public void engine() {
		System.out.println("아이언맨은 엔지니어에요");
	}

}
