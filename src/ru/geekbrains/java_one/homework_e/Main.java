package ru.geekbrains.java_one.homework_e;

public class Main {
	public static void main(String[] args) {
		Cat c = new Cat("Max", 200, 0, 2);
		Dog d = new Dog("Pongo", 500, 10, 0.5f);
		Dog d1 = new Dog("Rex", 600, 10, 0.5f);
		Horse h = new Horse("Spirit", 1500, 100, 3);
		Bird b = new Bird("Kesha", 5, 0, 0.2f);


		Animals[] zoo = {c, d, d1, h, b};
		for (int i = 0; i < zoo.length; i++) {
			System.out.println("Питомец:" + zoo[i].getName());

			System.out.println("Бег");
			zoo[i].run(-1);
			zoo[i].run(1);
			zoo[i].run(550);
			zoo[i].run(2000);
			System.out.println("заплыв");
			zoo[i].swim(-1);
			zoo[i].swim(5);
			zoo[i].swim(100);
			zoo[i].swim(150);
			System.out.println("Прыжки");
			zoo[i].jump(-1);
			zoo[i].jump(0.3f);
			zoo[i].jump(2.5f);
			zoo[i].jump(5);

		}

	}

}
