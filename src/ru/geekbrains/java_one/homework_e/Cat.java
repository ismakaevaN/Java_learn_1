package ru.geekbrains.java_one.homework_e;

public class Cat extends Animals {
	public Cat(String name, float runMaxLimit, float swimMaxLimit, float jupmMaxLimit) {
		super(name, runMaxLimit, 0, jupmMaxLimit);
	}

	@Override
	public String animalsType() {
		return "киса";
	}
}
