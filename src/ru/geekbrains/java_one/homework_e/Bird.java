package ru.geekbrains.java_one.homework_e;

public class Bird extends Animals {
	public Bird(String name, float runMaxLimit, float swimMaxLimit, float jupmMaxLimit) {
		super(name, runMaxLimit, 0, jupmMaxLimit);
	}

	@Override
	public String animalsType() {
		return "птичка";
	}
}
