package com.cathaybk.javaedu.lesson1.practice;

import java.util.Random;

public class AdvancedGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random random = new Random();
		int bw = 0;
		int aw = 0;

		while (aw < 2 && bw < 2) {
			int a = random.nextInt(3);
			int b = random.nextInt(3);
			String ame;
			String bme;
			if (a == 1) {
				ame = "石頭";
//				System.out.print("A出拳:石頭、");
			} else if (a == 2) {
				ame = "剪刀";
//				System.out.print("A出拳:剪刀、");
			} else {
				ame = "布";
//				System.out.print("A出拳:布、");
			}
			if (b == 1) {
				bme = "石頭";
//				System.out.print("B出拳:石頭，");
			} else if (b == 2) {
				bme = "剪刀";
//				System.out.print("B出拳:剪刀，");
			} else {
				bme = "布";
//				System.out.print("B出拳:布，");
			}
			String res;
			if (a == 1 && b == 0 || a == 2 && b == 1 || a == 0 && b == 2) {
				res = "B贏";
//				System.out.println("B贏");
				bw = bw + 1;
			} else if (a == b) {
				res = "平手";
//				System.out.println("平手");
			} else {
				res = "A贏";
//				System.out.println("A贏");
				aw = aw + 1;
			}
			System.out.printf("A出拳：%s、B出拳：%s，%s\n",ame,bme,res);
		}
//		if (aw == 2) {
//			System.out.println("最後贏家：A");
//		} else {
//			System.out.println("最後贏家：B");
//		}
		String whoWin = (aw == 2) ? "A":"B";
		System.out.printf("最後贏家：%s", whoWin);
	}
}
