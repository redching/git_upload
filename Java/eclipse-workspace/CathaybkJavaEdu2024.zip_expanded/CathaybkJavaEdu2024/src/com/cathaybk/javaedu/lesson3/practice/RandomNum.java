package com.cathaybk.javaedu.lesson3.practice;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class RandomNum {

//    public static void main(String[] args) {
//        doRandomSet();
//    }
//
//    private static void doRandomSet() {
//
//        Set<Integer> results = new TreeSet<>();
//        Random random = new Random();
//        while (results.size() < 5) {
//            results.add(random.nextInt(10) + 1);
//        }
//        System.out.println(results);
//    }
		public static void main(String[] args) {
			Random random = new Random();
			Set<Integer> res = new TreeSet<Integer>();
			while(res.size() < 5) {
				int number = random.nextInt(10)+1 ;
				res.add(number);
			}
			System.out.println(res);
		}
}
