package com.java.ex;

public class Warrior {
	private String name;
	private int hp;
	private int mp;
	private int level;
	private int strength;
	private int inteligent;
	private int agility;

	public Warrior() {
		this.level = 1;
		System.out.println("Empty Warrior Spawned");
		System.out.println("=====================");
	}

	public Warrior(String name, int strength, int inteligent, int agility) {
		this.name = name;
		this.strength = strength;
		this.inteligent = inteligent;
		this.agility = agility;
		this.hp = 50;
		this.mp = 50;
		this.level = 1;
		System.out.println(this.name + " Warrior Spawned");
		System.out.println("=====================");
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public void setInteligent(int inteligent) {
		this.inteligent = inteligent;
	}

	public void setAgility(int agility) {
		this.agility = agility;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public int getHp() {
		return hp;
	}

	public int getMp() {
		return mp;
	}

	public int getLevel() {
		return level;
	}

	public int getStrength() {
		return strength;
	}

	public int getInteligent() {
		return inteligent;
	}

	public int getAgility() {
		return agility;
	}
	
	public void wInfo() {
		System.out.println("Name: " + this.name);
		System.out.println("HP: " + this.hp);
		System.out.println("MP: " + this.mp);
		System.out.println("Strength: " + this.strength);
		System.out.println("Inteligent: " + this.inteligent);
		System.out.println("agility: " + this.agility);
		System.out.println("Level: " + this.level);
		System.out.println("AttackDMG: " + this.attack());
	}
	public int attack() {
		int attack = (this.strength * 3 + this.inteligent * 1 + this.agility * 2) * this.level;
		return attack;
	}

}
