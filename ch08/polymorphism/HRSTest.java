package com.ruby.java.ch08.polymorphism;

abstract class Employee {
	String name;
	int salary;

	public abstract void calcSalary();

	public abstract void calcBonus();
}

class Salesman extends Employee {
	public void calcSalary() {
		System.out.println("Salesman 급여 = 기본급 + 판매 수당");
	}

	public void calcBonus() {
		System.out.println("Salesman 보너스 = 기본급 * 12 * 4");
	}

	int annual_sales;
}

class Consultant extends Employee {
	public void calcSalary() {
		System.out.println("Consultant 급여 = 기본급 + 컨설팅 특별 수당");
	}

	public void calcBonus() {
		System.out.println("Consultant 보너스 = 기본급 * 12 * 2");
	}

	int num_project;
}

class Manager extends Employee {
	int num_team;

	@Override
	public void calcSalary() {
		// TODO Auto-generated method stub
		System.out.println("Manager 급여 = 기본급 + 특별 수당");
	}

	@Override
	public void calcBonus() {
		// TODO Auto-generated method stub
		System.out.println("Manager 보너스 = 기본급 * 12 * 6");

	}
}

class Director extends Manager {
	public void calcSalary() {
		System.out.println("Director 급여 = 기본급 + 컨설팅 특별 수당");
	}

	public void calcBonus() {
		System.out.println("Director 보너스 = 기본급 * 12 * 6");
	}
}

public class HRSTest {
	public static void main(String[] args) {
		Salesman s = new Salesman();
		Consultant c = new Consultant();
		Director d = new Director();

		s.calcBonus();
		c.calcBonus();
		d.calcBonus();
	}
}
