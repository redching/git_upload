package com.cathaybk.practice.nt50358.b;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Scanner;

public class PracticeFive {

	public static void main(String[] args) {

		int month;
		while (true) {
			Scanner in = new Scanner(System.in);
			System.out.print("輸入介於1-12之間的整數m:");
			month = in.nextInt();
			if (month >= 1 && month <= 12) {
				break;
			}
		}

		Calendar calendar = Calendar.getInstance();
		StringBuilder weekdayBuilder = new StringBuilder();
		weekdayBuilder = weekdayBuilder.append(" 日").append("  一").append("  二").append("  三").append("  四")
				.append("  五").append("  六");
		int year = LocalDate.now().getYear();
		System.out.printf("        %d年%d月          \n", year, month);
		System.out.println("--------------------------");
		System.out.println(weekdayBuilder);
		System.out.println("===========================");

		LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);
		int days = 0;
		days = firstDayOfMonth.lengthOfMonth();

		// month是index
		calendar.set(year, month - 1, 1);

		int firstDayInWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;

		for (int j = 0; j < firstDayInWeek; j++) {
			System.out.print("    ");
		}
		int cnt = firstDayInWeek;
		for (int i = 1; i <= days; i++) {
			if (cnt == 7) {
				System.out.printf("\n");
				cnt = 0;
			}
			System.out.printf("%2d  ", i);
			cnt++;
		}

		System.out.println();

	}
}