package ru.geekbrains.java_one.homework_a;

public class HelloJava {
		// задание 0
	public static void main(String[] args) {
		System.out.println("HelloJava");
		// задание 1
		float result1 = calculate(1, 3, 4, 2);
		System.out.println(result1);
		// задание 2
		boolean result2 = isSumInRange(7, 9);
		System.out.println(result2);
		result2 = isSumInRange(2, 43);
		System.out.println(result2);
		// задание 3
		System.out.println("Negative method:");
		System.out.println(isNegative(-1));
		System.out.println(isNegative(0));
		System.out.println(isNegative(1));
		printIsNegative(3);
		printIsNegative(-5);
		// задание 4
		System.out.println(greeting("Vika")); //result4
		System.out.println(greeting("Polya")); //result4
		// задание 5
		System.out.println("Leap year:");
		System.out.println(isLeapYear(800));
		System.out.println(isLeapYear(482));
		// задание 6
		System.out.println(isLeapYear(500));
		System.out.println(isLeapYear(496));
	}

	private static float calculate(int a, int b, int c, int d) {
		float result;
		result = a * (b + (c / d));
		return result;
	}

	public static boolean isSumInRange(int e, int f) {
		int sum = e + f;
		if (sum > 10 && sum <= 20) {
			return true;
		}
		return false;
	}

	public static boolean isNegative(int varibale){
		return varibale >= 0;
	}
	public static void printIsNegative(int g) {
		if (g >= 0){
			System.out.println(g + " положительное");
		} else {
			System.out.println(g + " отрицательное");
		}
	}

	public static String greeting(String name){
		return ("Привет, " + name + "!");
	}

	public static boolean isLeapYear(int h) {
		if (h % 4 == 0 && h % 100 != 0){
			return true;
		} else if (h % 400 == 0){
			return true;
		} else{
			return false;
		}
		}
}