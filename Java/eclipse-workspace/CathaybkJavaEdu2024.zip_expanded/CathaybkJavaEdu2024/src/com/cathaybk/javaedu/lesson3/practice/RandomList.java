package com.cathaybk.javaedu.lesson3.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class RandomList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		List<Integer> numarray = new ArrayList<>();
		while (numarray.size() < 15) {
			int number = random.nextInt(100) + 1;
			if (numarray.contains(number)) {
				continue;
			}
			numarray.add(number);
		}
//		Collections.sort(numarray);
		Collections.sort(numarray, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}

		});

		float sumnumber = 0;

		for (int i = 0; i < numarray.size(); i++) {
			sumnumber += numarray.get(i);

		}
		float avg = sumnumber / numarray.size();
		System.out.println(numarray);
		System.out.print("平均值：");
		System.out.printf( "%.5f",avg);
	}

}
