package ru.geekbrains.java_one.homework_d;

public class Main {
	public static void main(String[] args) {
		Employee h0 = new Employee("Петров", "Петр", "Петрович", "Директор", "000-00-00", 1500000f, 50);
		Employee h1 = new Employee("Федоров", "Федор", "Федорович", "Инженер", "111-11-11", 750000f, 41);
		Employee h2 = new Employee("Степанов", "Степан", "Степанович", "Столяр", "222-22-22", 500000f, 30);
		Employee h3 = new Employee("Иванова	", "Инна", "Ивановна", "Продавец", "333-33", 10000f, 23);
		Employee h4 = new Employee("Сидоров", "Сидор", "Алексеевич", "Грузчик", "444", 10000f, 64);
		System.out.println(h1.getSurname() + " " + h1.getName() + " " + h1.getPatronymic() + ", " + h1.getPosition());

		Employee[] employees = new Employee[5];
		employees[0] = h0;
		employees[1] = h1;
		employees[2] = h2;
		employees[3] = h3;
		employees[4] = h4;
		for (int i = 0; i < employees.length; i++) {
			if (employees[i].getAge() > 40) {
				System.out.println(employees[i].getSurname() + " " + employees[i].getName() + " " + employees[i].getPatronymic() + " (" + employees[i].getAge() + "), " + employees[i].getSalary());
			}
		}

		updateSalary(employees);
	}

	public static void updateSalary(Employee[] employees) {
		for (int i = 0; i < employees.length; i++) {
			if (employees[i].getAge() > 45) {
				employees[i].setSalary(employees[i].getSalary() + 5000f);
			}
		}
	}
}
