package com.cathaybk.practice.nt50358.b;

public class Sales extends Employee {
	private int bouns;
	private int payment;

	public Sales(String name, String department, int salary, int sale) {

		super(name, department, salary);
		this.bouns = (int) (sale * 0.05);
		this.payment = salary + this.bouns;
	}

	@Override
	public void printinfo() {
		super.printinfo();
		StringBuilder salesSBuilder = new StringBuilder();
		salesSBuilder = salesSBuilder.append("\n業績獎金：").append(bouns).append("\n總計：").append(payment);
		System.out.println(salesSBuilder.toString());
	}

	public int getBouns() {
		return bouns;
	}

	public void setBouns(int bouns) {
		this.bouns = bouns;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

}
