package com.cathaybk.practice.nt50358.b;

public abstract class Employee implements IWork {
	private String name;
	private String department;
	private int salary;

	@Override
	public void printinfo() {
		// TODO Auto-generated method stub
		System.out.printf("薪資單" + "\n姓名：" + name + " 部門：" + department + "\n月薪：" + salary);
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

	public Employee(String name, String department, int salary) {
		this.name = name;
		this.department = department;
		this.salary = salary;
	}

//	public abstract String toCSV() {
//		df
//	}

//	public Employee(String name2, String department2, int salary2) {
//		// TODO Auto-generated constructor stub
//	}

//	public Employee(String name, String department , int salary) {
//		
//		this.name = name;
//		this.department = department;
//		this.salary = salary;
////		this.salary = salary;
////		System.out.println("姓名："+name+"部門："+department);
//	}

}
