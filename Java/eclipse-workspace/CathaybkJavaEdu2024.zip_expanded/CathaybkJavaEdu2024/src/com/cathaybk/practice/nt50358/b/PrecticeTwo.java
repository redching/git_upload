package com.cathaybk.practice.nt50358.b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PrecticeTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			int number = random.nextInt(49) + 1;
			if (list.contains(number)) {
				i = i + 0;
				continue;
			} else {
				list.add(number);
			}
		}
		System.out.print("排序前：");
		for (int j = 0; j < list.size(); j++) {
			System.out.print(list.get(j) + " ");
		}

		System.out.println();
		Collections.sort(list);
		System.out.printf("排序後：");
		for (int z = 0; z < list.size(); z++) {
			System.out.print(list.get(z) + " ");
		}

//		for(int j = 0;j<list.size();j++) {
//			
//			System.out.println(list[j]);
//		}

	}

}
