package com.cathaybk.javaedu.lesson2.practice;

import java.util.Random;

public class ExceptionHandle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		int number = random.nextInt(100)+1;
		int res = number%2;
		try {
			if(res == 1) {
				System.out.println("奇數：" + number);
			} else{
				throw new Exception("偶數：" + number);
				
			}
		} catch (Exception ex1) {
			// TODO: handle exception
			 System.out.println(ex1);
			 ex1.printStackTrace(); //可以打印出錯誤檔案的路徑
		}
	}

}
