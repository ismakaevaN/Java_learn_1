package ru.geekbrains.java_one.homework_e;

public class Horse extends Animals {
	public Horse(String name, float runMaxLimit, float swimMaxLimit, float jupmMaxLimit) {
		super(name, runMaxLimit, swimMaxLimit, jupmMaxLimit);
	}

	@Override
	public String animalsType() {
		return "лошадка";
	}
}

