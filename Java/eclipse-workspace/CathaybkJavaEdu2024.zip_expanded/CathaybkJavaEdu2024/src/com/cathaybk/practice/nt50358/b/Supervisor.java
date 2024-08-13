package com.cathaybk.practice.nt50358.b;

public class Supervisor extends Employee {
	private int payment;

	public Supervisor(String name, String department, int salary) {
		super(name, department, salary);
		this.payment = salary;
	}

	@Override
	public void printinfo() {
		super.printinfo();
		System.out.print("總計：" + payment);
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

}
