package com.cathaybk.practice.nt50358.b;

public abstract class Employee implements IWork {
	private String name;
	private String department;
	private int salary;

	@Override
	public void printinfo() {
		StringBuilder empSBuilder = new StringBuilder();
		empSBuilder = empSBuilder.append("薪資單").append("\n姓名：").append(name).append(" 部門：").append(department).append("\n月薪：").append(salary);
		System.out.print(empSBuilder);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Employee(String name, String department, int salary) {//建構子在最上面
		this.name = name;
		this.department = department;
		this.salary = salary;
	}
}
