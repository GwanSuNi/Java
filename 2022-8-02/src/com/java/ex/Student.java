package com.java.ex;

public class Student {
	private String name;
	private int number;
	
	public Student(String name, int number) {
		this.name = name;
		this.number = number;
	}
	
	@Override
	public String toString() {
		return name + " : " + number;
	}
	
	@Override
	public boolean equals(Object obj) {
		String compareValue = obj.toString();
		String thisValue = toString();
		return thisValue.equals(compareValue);
	}
	
	@Override
	public int hashCode() {
		return toString().hashCode();
	}
	
}
