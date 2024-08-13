package com.cathaybk.practice.nt50358.b;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Scanner;

public class PracticeFive {

	public static void main(String[] args) {
		// 保存用户输入的年份
		int year = LocalDate.now().getYear();
		// 保存每个月的天数
		int days = 0;

		// 接受用户输入的年份
		int month;
		while (true) {
			Scanner in = new Scanner(System.in);
			System.out.print("輸入介於1-12之間的整數m:");
			month = in.nextInt();
			if (month >= 1 && month <= 12) {
				break;
			}
		}

		// 得到一个Calendar对象
		Calendar c = Calendar.getInstance();
		StringBuilder weekdayBuilder = new StringBuilder();
		weekdayBuilder = weekdayBuilder.append("日").append("   一").append("   二").append("   三").append("   四")
				.append("   五").append("  六");
		System.out.printf("        %d年%d月          \n", year, month);
		System.out.println("--------------------------");
		System.out.println(weekdayBuilder);
		System.out.println("===========================");

		LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);
		days = firstDayOfMonth.lengthOfMonth();

		// month是index
		c.set(year, month - 1, 1);

		int FirstDayInWeek = c.get(Calendar.DAY_OF_WEEK) - 1;

		int cnt = 0;

		for (int j = 0; j < FirstDayInWeek; j++) {
			System.out.print("    ");
			cnt++;
		}

		for (int i = 1; i <= days; i++) {
			if (cnt == 7) {
				System.out.printf("\n");
				cnt = 0;
			}
			System.out.printf("%2d  ", i);
			cnt++;
		}

		System.out.print("\n");

	}
}