package ru.geekbrains.java_one.homework_e;

public abstract class Animals {
	private String name;
	private float runMaxLimit;
	private float swimMaxLimit;
	private float jupmMaxLimit;

	public Animals(String name, float runMaxLimit, float swimMaxLimit, float jupmMaxLimit) {
		this.name = name;
		this.runMaxLimit = runMaxLimit;
		this.swimMaxLimit = swimMaxLimit;
		this.jupmMaxLimit = jupmMaxLimit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void run(float length) {
		if(length <= runMaxLimit && length > 0){
			System.out.println(animalsType() + " побежал!");
		} else {
			System.out.println(animalsType() + " спит!");
		}
	}

	public void swim(float length) {
		if(length <= swimMaxLimit && length > 0){
			System.out.println(animalsType() + " поплыл!");
		} else {
			System.out.println(animalsType() + " спит!");
		}
	}

	public void jump(float height) {
		if(height <= jupmMaxLimit && height > 0){
			System.out.println(animalsType() + " попрыгал!");
		} else {
			System.out.println(animalsType() + " спит!");
		}
	}

	public abstract String animalsType();
}

