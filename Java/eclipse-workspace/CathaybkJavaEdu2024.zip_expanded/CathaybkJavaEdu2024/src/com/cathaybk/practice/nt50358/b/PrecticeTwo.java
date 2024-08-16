package com.cathaybk.practice.nt50358.b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class PrecticeTwo {

	public static void main(String[] args) {
		Random random = new Random();
		List<Integer> list = new ArrayList<>();
		while (list.size()<6) {
			int number = random.nextInt(49) + 1;
			if (list.contains(number)) {
				continue;
			}else {
				list.add(number);
			}
		}
		System.out.print("排序前：");
		for (int res : list) {
			System.out.print(res + " ");
		}

		System.out.println();
		Collections.sort(list,new Comparator<Integer>() {
			public int compare(Integer o1,Integer o2) {
				return -o1.compareTo(o2);
			}
		});
		
		System.out.print("排序後：");
		for (int z = 0; z < list.size(); z++) {
			System.out.print(list.get(z) + " ");
		}
	}

}
