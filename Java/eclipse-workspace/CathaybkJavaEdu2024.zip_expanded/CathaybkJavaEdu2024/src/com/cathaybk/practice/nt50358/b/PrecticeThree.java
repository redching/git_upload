package com.cathaybk.practice.nt50358.b;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class PrecticeThree {
	public static void main(String[] args) {
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Sales("張志城", "信用卡部", 35000, 6000));
		employeeList.add(new Sales("林大鈞", "保代部", 38000, 4000));
		employeeList.add(new Supervisor("李中白", "資訊部", 65000));
		employeeList.add(new Supervisor("林小中", "理財部", 80000));
		for (Employee employee : employeeList) {
			employee.printinfo();
		}

		StringBuilder csvContent = new StringBuilder();
		try (BufferedWriter writer = new BufferedWriter(
				new FileWriter("C:\\Users\\Admin\\Downloads\\employees.csv", StandardCharsets.UTF_8))) {
			for (Employee employee : employeeList) {
				int payment;
				if (employee instanceof Sales) {
					Sales sales = (Sales) employee;
					payment = sales.getPayment();

				} else {
					Supervisor supervisor = (Supervisor) employee;
					payment = supervisor.getPayment();
				}
				csvContent.append(employee.getName()).append(",").append(payment).append("\n");
				writer.write(csvContent.toString());
				csvContent.setLength(0);
			}
		} catch (IOException e) {
			e.printStackTrace();

		}

	}

}
