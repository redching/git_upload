package com.cathaybk.javaedu.lesson1.practice;

public class Student {
	private String Name = "Jason";
	private int id = 8888;
	private int grade = 1 ;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public void print() {
		 System.out.println("Student [Name=" + Name + ", id=" + id + ", grade=" + grade + "]");
	}
	

}
