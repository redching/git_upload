package com.cathaybk.practice.nt50358.b;

import java.awt.event.MouseMotionAdapter;
import java.time.Year;
import java.util.Calendar;
import java.util.Scanner;

import javax.print.attribute.DocAttribute;

import animalprectice_extends.interface_pet;

public class PrecticeFive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inputmonth = new Scanner(System.in);
		Calendar calendar = Calendar.getInstance();// 引入日曆

		while (true) {
			System.out.println("輸入介於1~12之間的整數：");
			int monthnumber = inputmonth.nextInt();
			if (0 < monthnumber && monthnumber < 13) {
				int year = calendar.get(calendar.YEAR); // 獲得年
				System.out.println("      "+ year + "年" + monthnumber + "月");
				calendar.set(calendar.MONTH,monthnumber);
				
				System.out.println("----------------------");
				System.out.println("日 " + " 一 " + " 二 " + " 三 " + " 四 " + " 五 " + " 六 ");
				System.out.println("======================");
//				int day = calendar.get(Calendar.DAY_OF_WEEK);
//				System.out.println(day);
				break;
			} else {
				System.out.println("輸入錯誤");
			}
		}
		;

	}

}
