package ru.geekbrains.java_one.homework_e;

public class Dog extends Animals {
	public Dog(String name, float runMaxLimit, float swimMaxLimit, float jupmMaxLimit) {
		super(name, runMaxLimit, swimMaxLimit, jupmMaxLimit);
	}

	@Override
	public String animalsType() {
		return "песик";
	}
}
