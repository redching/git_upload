package com.cathaybk.practice.nt50358.b;

public class Supervisor extends Employee {
	private int payment;



	public Supervisor(String name, String department, int salary) {
		super(name, department, salary);
		this.payment =  salary;
//		System.out.println("月薪："+salary+"\n總計："+payment);
	}

	@Override
	public void printinfo() {
		// TODO Auto-generated method stub
		super.printinfo();
		System.out.println("\n總計："+payment);
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

}
