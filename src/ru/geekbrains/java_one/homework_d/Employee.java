package ru.geekbrains.java_one.homework_d;

public class Employee {
	private String surname;
	private String name;
	private String patronymic;
	private String position;
	private String phone;
	private float salary;
	private int age;

	private int id;
	private static int idCounter = 1;



	public int getId() {
		return id;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Employee(String surname, String name, String patronymic, String position, String phone, float salary, int age) {
		this.surname = surname;
		this.name = name;
		this.patronymic = patronymic;
		this.phone = phone;
		this.position = position;
		this.salary = salary;
		this.age = age;
		this.id = idCounter++;
	}
}

