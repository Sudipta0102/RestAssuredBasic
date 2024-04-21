package com.rest;

public class Employee implements Indentity {

	int age;
	String name;
	
	public int getAge() {
		return age;
	}
	public Employee setAge(int age) {
		this.age = age;
		
		return this;
	}
	public String getName() {
		return name;
	}
	public Employee setName(String name) {
		this.name = name;
		
		return this;
	}
	
	public String toString() {
		return "("+this.name+", "+this.age+")";
	}
}
