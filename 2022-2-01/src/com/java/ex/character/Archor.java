package com.java.ex.character;

public class Archor {
	private String name;
	private int level;
	private int hp;
	private int mp;
	private int intel;
	private int strength;
	private int agil;
	private int money;
	
	public Archor() {
		System.out.println("아무것도 입력 안한 궁수 - 생성할 때 할 일들을 이 블럭에 작성\n");
	}
	
	public Archor(String name, int hp, int mp, int intel, int strength, int agil, int money) {
		setLevel(1);
		setName(name);
		setHp(hp);
		setMp(mp);
		setIntel(intel);
		setStrength(strength);
		setAgil(agil);
		setMoney(money);
		
		System.out.println("값을 입력한 " + name + " 궁수가 생성됐습니다.\n");
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMp() {
		return mp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

	public int getIntel() {
		return intel;
	}

	public void setIntel(int intel) {
		this.intel = intel;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getAgil() {
		return agil;
	}

	public void setAgil(int agil) {
		this.agil = agil;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}
	
	public int calcDamage() {
		int cal = (intel * 1 + strength * 1 + agil * 2) * level;
		return cal;
	}

}
