package com.cathaybk.practice.nt50358.b;

public class Sales extends Employee {
	private int bouns;
	private int payment;

//	public Sales(String name, String department, int salary) {
//		super(name, department, salary);
//		// TODO Auto-generated constructor stub
//	}

	public Sales(String name, String department, int salary, int bouns) {
		super(name, department, salary);
		this.bouns = (int) (bouns * 0.05);
		this.payment = salary + this.bouns;
//		int sumsalary = salary + bouns;

	}

	@Override
	public void printinfo() {
		// TODO Auto-generated method stub
		super.printinfo();
		System.out.println("\n業績獎金：" + bouns + "\n總計：" + payment);
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
