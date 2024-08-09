package com.cathaybk.javaedu.lesson3.practice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomListagain {
	public static void main(String[] args) {

		float avg = 0;
		BigDecimal bigavg = new BigDecimal(avg);
		Random random = new Random();
		List<Integer> res = new ArrayList<>();
		float sumnumber = 0;
		for (int i = 0; i < 15; i++) {
			int number = random.nextInt(100) + 1;
			if (res.contains(number)) {
				continue;
			} else {
				res.add(number);

			}

		}
		Collections.sort(res);
		for (int j = 0; j < res.size(); j++) {
			sumnumber = sumnumber + res.get(j);
		}
		avg = sumnumber / res.size();

		System.out.println(res);
		System.out.printf("平均值： %.2f", avg);
		System.out.println(bigavg);

	}
}
